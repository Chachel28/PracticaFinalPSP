# Practica Final Ejercicio 1
- Enunciado
- Prerrequisitos
- Ejecución
### Enunciado
1. Aplicación 1:
    - A través de consola, solicita al usuario un número de registros a insertar.
    - A través de consola, solicita al usuario un número de hilos.
    - Inserta el número de registros introducido en una base de datos utilizando el número de hilos indicado. Los datos se generarán de forma aleatoria, debiendo estar los ingresos comprendidos entre 10 y 1000.
### Prerrequisitos
- Tener una base de datos con las siguientes características:
> - Database: BBDD_PSP_1
>
> - Table: EMPLEADOS
>
> - DB_USER: DAM2020_PSP
>
> - DB_PASSWORD: DAM2020_PSP
>
> - ID: PK. Integer. Autoincremental
>
> - EMAIL: varchar(100)
>
> - INGRESOS: Integer

- Tener instalado java en el ordenador

### Ejecución
1. Paso 1: Iniciar la base de datos
2. Desde un terminal ejecutar el comando "java -jar" junto con la ruta del archivo .jar
    1. Ejemplo:
    ```
    java -jar C:\Users\alexg\IdeaProjects\PracticaFinalPSP\PracticaFinalPSP-1.0-SNAPSHOT-jar-with-dependencies.jar
    ```
3. Introducir el numero de registros a insertar y el numero de hilos para usar (no puede haber mas hilos que registros)