#define TRANSITOR_PIN 3

// Température de consigne
float orderTemp = 17.0;
// Ecart de température maximal avant l'état critique
const float DELTA_CRITICAL = 3.0;
// Ecart de température maximal pour la régulation
const float DELTA_REG = 2.0;

// Modifier la température de consigne
void setOrderTemp(float orderTemp);
// Retourne vrai si risque de condensation
bool isDewPossible(float internalTemp, float dewPoint);
// Retourne vrai si le température est critique
bool isTempCritical(float internalTemp);
// Active / désactive le module à effet Peltier
void regulate(float internalTemp){
  if(internalTemp - orderTemp <= - DELTA_REG)
    digitalWrite(TRANSITOR_PIN, LOW);
  else if(internalTemp - orderTemp >= DELTA_REG)
    digitalWrite(TRANSITOR_PIN, HIGH);
  else
    return;
}

// Implémentations
void setOrderTemp(float newOrderTemp){
  orderTemp = newOrderTemp;
}
bool isDewPossible(float internalTemp, float dewPoint){
  return (internalTemp <= dewPoint)? true:false;
}
bool isTempCritical(float internalTemp){
  return (internalTemp - orderTemp  >= DELTA_CRITICAL)? true:false;
}
