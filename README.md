<h1 align="center">Invetory </h2>

### **Sistema de Inventario de Equipos Tecnológicos en Laboratorios de Computación**

<h2 align="center"> Descripción General </h2>

El Sistema de Inventario de Equipos Tecnológicos en Laboratorios de Computación es una aplicación basada en Java diseñada para gestionar y monitorear el equipo tecnológico en laboratorios de computación. Este sistema ayuda a mantener un registro actualizado de todos los equipos, asegurando un seguimiento y gestión eficientes de los artículos tanto funcionales como no funcionales.

## Características
1. **Panel de Control**: Proporciona una representación visual del número total de equipos en buen estado y defectuosos.
2. **Gestión de Equipos**: Permite agregar, actualizar y eliminar registros de equipos.
3. **Registros de Inventario**: Muestra una lista detallada de todos los equipos con sus respectivos números de inventario y fechas de ingreso.
4. **Gestión de Personal**: Administra los registros del personal responsable de los equipos.
5. **Seguimiento de Movimientos**: Rastrea el movimiento de equipos entre diferentes ubicaciones.
6. **Generación de Informes**: Genera informes para análisis y registro.
7. **Verificación de Equipos**: Facilita el proceso de verificación del estado de los equipos.
8. **Gestión de Laboratorios**: Administra múltiples laboratorios y sus respectivos equipos.

## Tecnología Utilizada
- **Lenguaje de Programación**: Java (NetBeans IDE)
- **Kit de Desarrollo de Java**: JDK versión 17.0.6 (LTS)
- **Base de Datos**: Microsoft SQL Server

## Instalación y Configuración
1. **Instalación de Java**: Asegúrese de tener instalada la versión 17.0.6 del JDK en su sistema. Puede descargarla desde el sitio web oficial de Oracle.

   ```sh
   java -version
   ```
   Asegúrese de que la salida muestre JDK 17.0.6.
2. **Instalación de NetBeans**: Descargue e instale NetBeans IDE desde el sitio web oficial.
3. **Configuración de SQL Server**: Asegúrese de tener SQL Server instalado y en funcionamiento. Cree una base de datos para el sistema de inventario utilizando los scripts disponibles en la carpeta scripts del repositorio.
4. **Configuración de la Base de Datos**: Actualice la configuración de conexión a la base de datos en la aplicación para conectar con su instancia de SQL Server.

## Ejecución de la Aplicación
1. **Clonar el Repositorio**: Clone el repositorio del proyecto desde el sistema de control de versiones.

   ```sh
   git clone https://github.com/david-mrios/Inventory-JAVA-NEATBEANS.git
   ```
2. **Abrir Proyecto en NetBeans**: Abra NetBeans IDE, vaya a Archivo > Abrir Proyecto y seleccione el repositorio clonado.
3. **Configurar Conexión a la Base de Datos**: Abra la carpeta `src/servicios/config.txt` y actualice la configuración de conexión a la base de datos en el archivo de configuración.
4. **Compilar y Ejecutar**: Limpie y compile el proyecto usando NetBeans. Ejecute la aplicación para iniciar el sistema de inventario.