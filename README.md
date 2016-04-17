# Trabajo Práctico - Diseño de Sistemas - 2016

## Grupo: 1

Development status: [![Build Status](https://travis-ci.com/dds-utn/2016-jm-group-01.svg?token=EaTqdb9dSHiWJuznnW6B&branch=development)](https://travis-ci.com/dds-utn/2016-jm-group-01)

Master status: [![Build Status](https://travis-ci.com/dds-utn/2016-jm-group-01.svg?token=EaTqdb9dSHiWJuznnW6B&branch=master)](https://travis-ci.com/dds-utn/2016-jm-group-01)

#### Integrantes: 
- Daiana Espinoza
- Ivan Rufino
- Natasha Alik Torokian
- Lucas Giuliano Lercari
- Matías Caricato

#### Ayudante:
- Federico Cano

# Enunciado
## Contexto

El gobierno de la ciudad, con el objetivo descentralizar el acceso a la información y disminuir la congestión en centros de Gestión y Participación (CGPs), quiere llevar a cabo un proyecto ambicioso: contar con dispositivo táctiles en múltiples esquinas de la ciudad, conectados a internet, que permitan realizar trámites y obtener información. 

  

Tras contactarse con la Regional Buenos Aires, de la Universidad Tecnológica Nacional., y recibir la propuesta en la Cátedra de Diseño de Sistemas, luego de varias reuniones y discusiones sobre cómo abordar el proyecto, todas las partes están de acuerdo en encarar una primera etapa en la que estos dispositivos sólo visualizarán puntos de interés, en algunas locaciones particulares. Si el proyecto tiene éxito, en etapas posteriores se incluirán más dispositivos y más funcionalidades. 

  

## Dominio de alto nivel

  

Un punto de interés (POI, por sus siglas en inglés) es básicamente una posición en un mapa, que suele representarse mediante un ícono.

  

De este conocemos  su dirección, calle principal, entre qué calles se encuentra, número, y datos más específicos como el piso, departamento, unidad, el código postal, localidad, barrio, provincia, país, además de las coordenadas geográficas resultado del proceso de geocodificación: latitud y longitud. 

  

Algunos puntos de interés posibles son:

- Paradas de colectivos 
- Centros de Gestión y Participación (CGP) 
- Sucursales de Bancos 
- Locales comerciales 

## Requerimientos de alto nivel

Cada uno de estos dispositivos, más allá de sus particularidades físicas, es una computadora conectada a Internet. Los mismos serán provistos por otra empresa, “Touch.me”.

  

Nuestra responsabilidad será, entonces, diseñar, construir, probar y desplegar el sistema software que se ejecutará en estas máquinas. 

  

El mismo cubrirá, al menos, las siguientes funcionalidades:

- Buscar puntos de interés, según criterios de búsqueda establecidos por el usuario 
- Obtener información de un cierto punto 
- Visualizar el resultado de las consultas 
- Almacenar información de la consulta, con fines estadísticos.  
  

Este sistema no sólo será utilizado por transeúntes en la via pública, sino también por administradores del sistema, del Gobierno de la ciudad, que cargarán puntos desde distintos orígenes, y obtendrán estadísticas sobre las consultas. 



## Entregas

### Entrega 0A - Análisis del Dominio [Opcional]

Para empezar, vamos a hacer un análisis preliminar del sistema: queremos identificar casos de uso y usuarios involucrados. Para ello, se solicita: 

  

1. Modelar los Casos de Uso(CU) del dominio. 
2. Modelar Diagramas de Secuencia y de Clases en UML para comunicar el Diseño de los CU. 
3. Definir Atributos de calidad y Requerimientos No Funcionales en base al Contexto del Sistema. 
  

### Entrega 0B - Prueba de Concepto - Tecnología [Recomendada]

  

Para empezar a empaparse en la tecnología, vamos a realizar una pequeña prueba de concepto de la misma: modelar los POIs. De los mismos nos interesá:

  

- Su coordenada: latitud y longitud 
- Un nombre, direción (calle y altura) 
- Si es una parada de colectivos, un CGP, etc 
  

Además, a un POI queremos conocer:

- Si se encuentra a menos de X metros de otro POI 
- Si es válido: no puede haber POIs sin geolocalizar ni a los que les falte nombre.  
  

Se solicita: 

1. Crear un proyecto en la tecnología orientada a objetos seleccionada 
2. Utilizando un entorno de desarrollo integrado (IDE)  
3. Mantener los cambios en un sistema de control de versiones 
  

### 

### Entrega 1 [Obligatoria]

  

Queremos que las personas sean capaces de saber si pueden ir desde nos encontramos hacia otro lugar. Para ello vamos a ofrecerles tres servicios: consulta de cercanía, consulta de disponibilidad (horaria) y búsqueda de puntos.

#### Cálculo de cercanía

En general, decimos que estamos cerca de un punto de interés si se encuentra a una distancia menor a 5 cuadras. 

  

Sin embargo, hay excepciones:

1. Un parada de  colectivo se considera cercana si estamos a menos de una cuadra. 
2. Los CGP cumplen la condición de cercanía, si su coordenada está dentro de la zona delimitada por la comuna. 
3. Para los locales comerciales, cada rubro define el radio de cercanía. Ejemplo: para las librerías escolares se considera cerca si está en un radio de 5 cuadras, para un kiosco de diarios en cambio son 2 cuadras, y así sucesivamente. 

#### Cálculo de disponibilidad

  

El cálculo de disponibilidad trata de saber si un POI está disponible en un cierto momento. Esto depende de cada tipo de POI:

  

1. El servicio de transporte de Colectivos está disponible a toda hora 
2. Para los CGP: 
    1. si se ingresa un valor x (el nombre de un servicio), la fecha debe estar en el rango de atención. Ej: si es sábado no se atiende Rentas, no está disponible. Si es lunes a las 20hs tampoco se encuentra disponible este servicio. En cambio si es lunes a las 10:30hs sí se encuentra disponible. 
    2. si no se ingresa un valor x, considerar que exista al menos un servicio en el CGP que esté atendiendo en ese momento. 

3. Para los Bancos, el mismo comportamiento que para los CGP pero considerando el horario de atención bancario (Lunes a Viernes de 10hs a 15hs) 
4. Para los locales comerciales,  considerar el horario de atención del local. Ejemplo: para Carrousel el horario de atención es de Lunes a Sábado de 10hs a 13hs y de 17hs a 20:30hs. Si son las 15 horas de un martes no debe estar disponible. 
  
  

### Búsqueda de puntos

Finalmente, necesitamos buscar puntos en el mapa a partir de un texto libre, por ejemplo:

- Si se ingresa el texto "114", se debería encontrar las paradas del colectivo 114.  
- Si se ingresa una palabra que corresponde a un rubro (por ejemplo "mueblería"), se deberían encontrar todos los cales de ese rubro. 
- Si se ingresa una palabra clave, se debería encontrar todos los puntos que estén etiquetados mediante esa palabra clave.  
- Si se ingresa parte de un servicio (por ejemplo "asesoramiento"), se deben encontrar todos CGPs que provean algún servicio parecido (por ejemplo "asesoramiento legal") 

#### Requerimientos detallados

  

1. Determinar cuándo un punto de interés está cerca de una coordenada geográfica.  
2. Dado un momento (fecha:hora:minutos:segundos) y un valor x, determinar si un negocio está disponible. 
3. Buscar un punto de interés en base a un texto libre 
4. Diseñar e implementar los casos de prueba para cada uno de los 3 requerimientos anteriores.
