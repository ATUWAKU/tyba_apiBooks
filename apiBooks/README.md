# apiBook
Es un robot de pruebas de servicios para el servicio [restful-booker](https://restful-booker.herokuapp.com/apidoc/index.html)

El robot se construye utilizando Intellij Community y el lenguaje de programación Java y gradle como gestor de dependencias y compilador del proyecto.

Se utiliza la técnica de pruebas BDD; esta se implementa haciendo uso del lenguaje Gherkin escrito en la herramienta Cucumber.

Se usa Rest-Assured como framework (el cual hace parte de Serenity) de conectividad con el servicio web.

Se hace uso de Serenitybdd como herramienta para la implementación del patrón de automatización Screenplay y la generación de informes de resultados de las pruebas.

Para versionar el código fuente se utiliza git como herramienta de gestión de código, Gihub com repositorio, trunk base development como estándar de versionamiento y Sonar como herramienta para realizar análisis de código estático.

Las versiones de las herramientas se detallan a continuación.

```shell
Intellij Community 2021.3.2 
Java 11 Openjdk version "11.0.2" 2019-01-15
Gradle wrapper 7.4.1
SerenityBdd 3.2.5
Cucumber 3.2.5
Rest-Assured 3.25
Git 2.35.1.2 
Sonar 9.4.0.54424
```
------------------------------------------------------
#Automatización

##Configuraciones de ejecución
###En Local

Para correr la automatización de forma local se debe:
1. Instalar [Java](https://openjdk.java.net/projects/jdk/11) y configurar la [varialbe de entorno](https://www.java.com/es/download/help/path_es.html)
2. Instalar [Gradle](https://gradle.org/releases) y su [variable de entorno configurada]((https://gradle.org/install/#manually))

##Ejecución
###Datos para la ejecución
Los datos para la ejecución los encuentra en cada uno de los feature.

####Todos los test
gradlew clen build test aggregate

###Informe de resultados
El informe de resultados lo encuentran en la carpeta donde está el proyecto en la ruta target\site\serenity\index.html

