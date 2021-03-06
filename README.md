# intervals
La practica consiste en realizar mediante TDD la operación de calcular si dos intervalos intersectan.

## Tipos de intervalo
1. Cerrado [a,b]
   <br/>Intervalo cerrado [a,b] es el conjunto de todos los números a <= x <= b
1. Abierto (a,b]
   <br/>Intervalo abierto (a,b] es el conjunto de todos los números a < x < b

## Diseño casos de prueba _intersects(]_

### NO INTERSECTAN 
```
---[---]-----------   
**********[***]***    No intersectan. Ni mínimo/máximo intervalo1 coinciden con intervalo2

---------[---]-----  
**[***]************   No intersectan. Ni mínimo/máximo intervalo1 coinciden con intervalo2
```
### SOLO COINCIDE 1 EXTREMO 
```
-----[---]---------
*********[***]*****   No intersectan. Ni mínimo/máximo están contenido en intervalo2

---------[---]-----
*****[***]*********   No intersectan. Máximo

-----[---]---------
*********[***]*****   No intersectan. Uno OPEN / otro CLOSED

---------[---]-----
*****[***]*********   No intersectan. Ambos OPEN / otro CLOSED

-----[---]---------  
*****[***]*********   No intersectan. Ambos OPEN
``` 

### INTERSECTAN CUANDO EXTREMOS NO COINCIDENTES
```
-----[---]---------
***[***]***********   Intervalo1 contiene máximo del intervalo2

-----[----]--------
********[****]*****   Intervalo1 contiene mín del intervalo2

Con los 2 anteriores ya estarían cubiertos los siguientes casos:
-----[------]------
*******[**]********   

-------[--]--------
*****[******]******     
```
### INTERSECTAN CUANDO EXTREMOS COINCIDENTES
``` 
-----[-----]-------
*****[*********]***  Intervalo1 min cerrado = Intervalo2 min cerrado

------[-----]------
***[********]******  Intervalo1 max cerrado = Intervalo2 max cerrado
 
------[----]-------
******[****]*******  Este caso ya está contenido en los anteriores
```


 
