#include <DHT.h>

//definition of the local variables
#define pinDHT22 8
#define DHTtype DHT22

//declaration of the program's variables
double Temperature;
double Humidity;
double Tr;
double K;
int ThermistorPin = A0;
double vTherm = 0;
double T;
int RedLEDPin=6;
int GreenLEDPin=7;

//initialize THE DHT11 sensor by giving the pin where is connected and its kind
DHT dht(pinDHT22,DHTtype);

// the setup routine runs once when you press reset:
void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  pinMode(ThermistorPin, INPUT);
  pinMode(RedLEDPin, OUTPUT);
  pinMode(GreenLEDPin, OUTPUT);
  
  Serial.println("DHT22 Testing Program");
  Serial.println("==========================");
  Serial.println();
  
  //start the DHT sensor
  dht.begin();
}

void loop() {
  // put your main code here, to run repeatedly:
  TemperatureValue();
  Dew_Point();
  

  /*if (Humidity < 30)
  {
    digitalWrite(6, HIGH);
    digitalWrite(7, LOW);
    Serial.println("WARNING !!!! The air is too dry.");
    Serial.println();
   // delay in between reads for stability
    delay(2000);
  }
  else if( Humidity >= 30 and Humidity <= 70)
  {
    digitalWrite(6, LOW);
    digitalWrite(7, HIGH);
    Serial.println("Fortunately, everything is well.");
    Serial.println();
    // delay in between reads for stability
    delay(2000);
  }
  else if (Humidity > 70)
  {
    digitalWrite(6, HIGH);
    digitalWrite(7, LOW);
    Serial.println("WARNING !!!! There is a risk of condensation because the air is too wet.");
    Serial.println();
   // delay in between reads for stability
    delay(2000);
  }
  else{
    digitalWrite(6, LOW);
    digitalWrite(7, LOW);
  }*/
}
double toVolts(int voltage){
  return(5*voltage)/1024;

}
void TemperatureValue(){
   vTherm=toVolts(analogRead(A0));
   T = (vTherm-0.6)/(-0.00165);
   Serial.print("Temperature:");
   Serial.print(T);
   Serial.println(" °C"); 
   delay(1000);
}
void Dew_Point(){
  
// Reading of the external temperature
  Temperature = dht.readTemperature();
  
  // Reading of the humidity rate 
  Humidity = dht.readHumidity(); 

  //Calculation of the constant K
  K = ((17.27 * Temperature) / (237.7 + Temperature)) + log(Humidity/100);
 
 // Tr = ((pow(Humidity/100,1/8)*(112+(0.9*Temperature)))+(0.1*Temperature)-112);
  //Calculation of the dew point
  Tr = (237.7 * K) / (17.7 - K);
  
  // Data Verification
  if (isnan(Humidity) || isnan(Temperature)) {
    Serial.println("No value returned by the DHT11. Is it correctly plug in ?");
    digitalWrite(6, LOW);
    digitalWrite(7, LOW);
    delay(2000);
    return; //If no value is received by the Arduino board, it waits for 2 seconds then it restarts the loop() function
  }

  //Display the temperature read by the DHT11 sensor
  Serial.print("External Temperature : "); 
  Serial.print(Temperature); 
  Serial.println(" °C");
  
  //Display the humidity read by the DHT11 sensor
  Serial.print("Humidity : "); 
  Serial.print(Humidity); 
  Serial.println(" %");

  //Display the calculated dew point
  Serial.print("Dew Point : "); 
  Serial.print(Tr); 
  Serial.println(" °C");

  // delay in between reads for stability
  delay(1000);

  if(Temperature >= Tr){
    digitalWrite(6, HIGH);
    digitalWrite(7, LOW);
    Serial.println();
    Serial.println("WARNING !!!! There is a risk of condensation.");
    Serial.println();
   // delay in between reads for stability
    delay(3000);
  }
  else{
    digitalWrite(6, LOW);
    digitalWrite(7, HIGH);
    Serial.println();
    Serial.println("Fortunately, there is no problem.");
    Serial.println();
    // delay in between reads for stability
    delay(3000);
  }
}
