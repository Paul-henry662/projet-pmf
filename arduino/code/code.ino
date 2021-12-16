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
    Serial.print(dewPoint);
    Serial.print(":");
    Serial.print((int) dewPossible);
    Serial.print(":");
    Serial.print((int) tempCritical);
    Serial.print(";");
    Serial.print("\n");
  }

  if(Serial.available() > 0){
    float newOrderTemp = Serial.readString().toFloat();
    setOrderTemp(newOrderTemp);
  }

  regulate(internalTemp);
  
  delay(2000);
}
