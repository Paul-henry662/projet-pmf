#define PELTIER 3

// Température de consigne
float orderTemp = 35.0;
// Ecart de température maximal avant l'état critique
const float DELTA_CRITICAL = 3.0;
// Ecart de température maximal pour la régulation
const float DELTA_REG = 2.0;

int power = 0;
int peltierLevel = 0;

// Modifier la température de consigne
void setOrderTemp(float orderTemp);
// Retourne vrai si risque de condensation
bool isDewPossible(float internalTemp, float dewPoint);
// Retourne vrai si le température est critique
bool isTempCritical(float internalTemp);
// Active / désactive le module à effet Peltier

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
void regulate(float internalTemp){
  float error = internalTemp - orderTemp;
  power += 1 * error;

  if(power > 99)
    power = 99;
  if(power < 0)
    power = 0;

  peltierLevel = map(power, 0, 99, 0, 255);
  analogWrite(PELTIER, peltierLevel);
}
