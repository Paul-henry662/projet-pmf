#include <DHT.h>

#define DIODE_VOLTAGE_PIN A0
#define DHT_PIN 6
#define DHT_TYPE DHT22

// Constantes de la diode
// diodeVoltage = A * internalTemp + B
const float A = -0.00165;
const float B = 0.6;

// Constantes de la formule de Magnus
const float ALPHA = 17.27;
const float BETA = 237.7;

DHT dht(DHT_PIN, DHT_TYPE);

float getInternalTemp();
float getExternalTemp();
float getAmbiantHumidity();
float getDewPoint(float temperature, float humidity);

float getInternalTemp(){
  int rawDiodeVoltage = analogRead(DIODE_VOLTAGE_PIN);
  float diodeVoltage = (5.0 / 1023.0) * rawDiodeVoltage;

  return (diodeVoltage - B) / A;
}

float getExternalTemp(){
  return dht.readTemperature();
}

float getAmbiantHumidity(){
  return dht.readHumidity(); // En %
}

float getDewPoint(float temperature, float humidity){
  float k = ( (ALPHA * temperature) / (BETA + temperature) ) + log(humidity / 100);

  return (BETA * k) / (ALPHA - k);
}
