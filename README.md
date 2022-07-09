# Módulo 5 - Grupo 1
***
## Integrantes
- Daniela Mendez
- Aracelly Rodriguez

## Descripción

Sistema de consultoria de prevención de riesgo, se realizan CRUD a usuarios, capacitaciones principalmente.

Tecnologia utilizada:
- Java (JEE)
- MYSQL
- Bootstrap

Patrón de diseño MVC.

## Consideraciones:
- Se asume que el usuario ingresa los datos que corresponde, ya que no nos enfocamos en realizar válidaciones ni tanto del front ni del backend (solo algunas).
- Si quiere ingresar un usuario y el rut ya existe en la Bd no se almacenará.
- Los campos con asteriscos son obligatorios.
- Se asume que no se proceden inconsistencias en un CRUD a la base datos, ya que no se implementaron modelos transaccionales para validar consistencia cuando se modificaba má de una tabla en una petición.

## Repositorio: