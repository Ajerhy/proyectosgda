#Sistema de Gestion Direccion Academica
proyectosgda
![Sistema de Gestion Direccion Academica](logo.png)

###################
Proyectosda
###################

https://start.spring.io/
Descargar Configurar Mave NetBeans
https://mkyong.com/maven/how-to-install-maven-in-windows/
http://maven.apache.org/download.cgi
==========
**SISTEMA WEB**
*   La primera versión se lanzará a finales de 2017. Feature requests and bug reports

Framework Spring Boot

Web
Thymeleaf
Devtools

Netbean
*******
NetBeans IDE 8.0.1
1.8.0_111
*******
Parar App

********
Generar
Ejecutar
********
http://localhost:8090/

descargar spring boot startert to lowwer version
update the maven proyecto



    /*
    @GetMapping("/listar")
    @RequestMapping(value = "/listar",method = RequestMethod.GET)
    @GetMapping("/guardar")
    @RequestMapping(value = "/guardar",method = RequestMethod.POST)
    REST FULL WEBSERVICE
    @GetMapping("/eliminar")
    @RequestMapping(value = "/eliminar",method = RequestMethod.DELETE)
    @GetMapping("/actualizar")
    @RequestMapping(value = "/actualizar",method = RequestMethod.PUT)
    */

Tabulacion de NetBeans
Alt+ Shift+F

Corregir 
JDK jdk1.8.0_271
JRE 8.0_271

Actualizar Maven
Netbeantsy Variable de entorno

NETBEANS
C:\Program Files\NetBeans 8.0.2\etc
netbeans.conf
Linea 46
*Antes*
netbeans_default_options="-J-client -J-Xss2m -J-Xms32m -J-XX:PermSize=32m -J-Dapple.laf.useScreenMenuBar=true -J-Dapple.awt.graphics.UseQuartz=true -J-Dsun.java2d.noddraw=true -J-Dsun.java2d.dpiaware=true -J-Dsun.zip.disableMemoryMapping=true"
*Ahora*
-J-Djdk.lang.Process.allowAmbiguousCommands=true
netbeans_default_options="-J-Djdk.lang.Process.allowAmbiguousCommands=true -J-client -J-Xss2m -J-Xms32m -J-XX:PermSize=32m -J-Dapple.laf.useScreenMenuBar=true -J-Dapple.awt.graphics.UseQuartz=true -J-Dsun.java2d.noddraw=true -J-Dsun.java2d.dpiaware=true -J-Dsun.zip.disableMemoryMapping=true"
