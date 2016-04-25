/*
 * Archivo que enseña a trabajar con conexiones Java Data Base Connection 
 */
package javadatabaseconnection_jdbc;

//01. importar librería SQL completa
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

//02    Descargar conector de Java para MySQL
//  02.01    Googlear: MySQL Java Connector
//  02.02    Abrir el link https://dev.mysql.com/downloads/connector/j/3.0.html o similar
//  02.03    Seleccionar versión, en este caso 3.17
//  02.04    Seleccionar plataforma, en este caso "Platform Independent"
//  02.05    Seleccionar descargar versión TAR o ZIP
//      02.05.01  Log in a Oracle
//  02.06    Descargar archivo
//  02.07    Descomprimir
//  02.08    Chequear que exista un archivo .jar (mysql-connector-java-3.0.17-ga-bin.jar)

//03    Agregar el conector al proyecto
//  03.01    En la carpeta del proyecto actual:
//  03.02    Buscar la carpeta Libraries
//  03.03    Click con el botón derecho
//  03.04    Seleccionar Add JAR/Folder
//  03.05    Buscar el archivo .jar (mysql-connector-java-3.0.17-ga-bin.jar)

//04    Tener un servidor MySQL funcionando
//  04.01    Instalar MySQL
//      04.01.01    Descargar XAMPP
//          04.01.01.01 Ir a https://www.apachefriends.org/index.html
//          04.01.01.02 Seleccioar plataforma (Windows) 
//          04.01.01.03 Descargar 
//      04.01.02    Instalar XAMPP
//          04.01.02.01 Ejecutar Instalador
//          04.01.02.02 Seleccionar [OK] al Warning de UAC
//          04.01.02.03 Seleccionar todos los servicios a instalar.
//          04.01.02.04 Seleccionar una carpeta de instalación (C:\xampp)
//          04.01.02.05 Press [Finish] and start the XAMPP Control Panel
//          04.01.02.06 Select the language
//      04.01.03    Start MySQL
//          04.01.03.01 On the XAMPP Control Panel, Start Apache and MySQL with the button [Start]
//          04.01.03.02 If there is a problem starting Apache
//              04.01.03.02.01  Open the file C:\Xammp\Apache\Conf\httpd.conf
//              04.01.03.02.02  Search the line that says "Listen 80"
//              04.01.03.02.02  Change the text for "Listen 8080"
//          04.01.03.03 Give Apache and MySQL permission to access networks
//      04.01.04    Descargar MySQL
//          04.01.04.01 Ir a http://www.mysql.com/
//          04.01.04.02 Click en Community (GPL) Downloads » bajo MySQL Community Edition (GPL)
//          04.01.04.03 Seleccionar MySQL Community Server (GPL)
//          04.01.04.03 Seleccionar Sistema Operativo y Versión (Windows (x86, 64-bit), ZIP Archive)
//      04.01.05    Proteger acceso a phpMyAdmin con contraseña
//          04.01.05.01 Abrir http://localhost/phpmyadmin/
//          04.01.05.02 o http://localhost:8080/phpmyadmin/ si se ha cambiado el puerto
//          04.01.05.03 Ir a User Accounts
//          04.01.05.03 para el usuario "root" con el Host Name "127.0.0.1"
//              04.01.05.03.01 Seleccionar "Edit Privileges"
//              04.01.05.03.02 Seleccionar [Change Password]
//              04.01.05.03.03 Marcar el radio button "Password"
//              04.01.05.03.04 Escribir el nuevo password y confirmarlo
//              04.01.05.03.05 Presionar [Go]
//          04.01.05.04 para el usuario "root" con el Host Name "localhost"
//              04.01.05.04.01 Seleccionar "Edit Privileges"
//              04.01.05.04.02 Seleccionar [Change Password]
//              04.01.05.04.03 Marcar el radio button "Password"
//              04.01.05.04.04 Escribir el nuevo password y confirmarlo
//              04.01.05.04.05 Presionar [Go]
//      04.01.06    Download the latest phpMyAdmin
//          04.01.06.01 Go to http://phpmyadmin.net
//          04.01.06.02 Download the latest version
//          04.01.06.03 Unzip the file
//          04.01.06.04 Change the extracted folder nameto phpMyAdmin
//          04.01.06.05 Move the folder phpMyAdmin to the folder C:\xampp\htdocs
//  04.02    Iniciar MySQL phpMyAdmin
//      04.02.01    Abrir en el navegador
//        04.02.01.01    http://localhost/phpMyAdmin/
//        04.02.01.02    o http://localhost:8080/phpMyAdmin/ si se ha cambiado el puerto
//        04.02.01.03    Log in usando el usuario root y su contraseña


public class JavaDataBaseConnection_jdbc {

    public static void main(String[] args) {
        try {
            System.out.println("Intento de conexión a base de datos...");
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1/contacts", "root", "root");
            System.out.println("La conexión se ha realizado con éxito");
            
            //Get the contents of a table:
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM countries");
            
            System.out.println("ID\tNombre\tDominio\tCódigo");
            while (rs.next()) {
                System.out.println(rs.getString("country_id")+"\t"
                        +rs.getString("country_name")+"\t"
                        +rs.getString("internet_domain")+"\t"
                        +rs.getString("country_code"));
            }
        } catch (SQLException sqle) {
            System.out.println("Error MySQL: " + sqle.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("The line: " + ex.toString() + " Caused the error:" + ex.getMessage());
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            e.getStackTrace();
        }
    }    
}
