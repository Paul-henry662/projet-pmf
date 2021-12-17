#include "Mesures.h"
#include "Regulation.h"

// Variables globales
float internalTemp = 0.0;
float externalTemp = 0.0;
float ambiantHumidity = 0.0;
float dewPoint = 0.0;

bool dewPossible = false;
bool tempCritical = false;

void setup() {
  Serial.begin(9600);
  pinMode(PELTIER, OUTPUT);
  dht.begin();
}

void loop() {
  float newInternalTemp = getInternalTemp();
  float newExternalTemp = getExternalTemp();
  float newAmbiantHumidity = getAmbiantHumidity();
  
  if(newInternalTemp != internalTemp || newExternalTemp != externalTemp || newAmbiantHumidity != ambiantHumidity){
    internalTemp = newInternalTemp;
    externalTemp = newExternalTemp;
    ambiantHumidity = newAmbiantHumidity; // En %
    dewPoint = getDewPoint(externalTemp, ambiantHumidity);

    dewPossible = isDewPossible(internalTemp, dewPoint);
    tempCritical = isTempCritical(internalTemp);

    Serial.print(internalTemp);
    Serial.print(":");
    Serial.print(externalTemp);
    Serial.print(":");
    Serial.print(ambiantHumidity);
    Serial.print(":");
    Serial.print(dewPossible);
    Serial.print(":");
    Serial.print(tempCritical);
    Serial.print(";");
    Serial.print("\n");
  }

  /*if(Serial.available() > 0){
    //Serial.println("available");
    float newOrderTemp = Serial.parseFloat();
    setOrderTemp(newOrderTemp);
    //Serial.print("nouvelle température:");
    //Serial.print(newOrderTemp);
    
  }*/

  regulate(internalTemp);
  
  delay(2000);
}
