Feature: obtener recursos de un modulo externo

  Scenario: Traer empleados de modulo externo
    Given un empleado del area de recursos
    When consulto los empleados
    Then tengo una lista de empleados