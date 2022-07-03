package com.squad_5.recursos.Recursos.Models;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Empleado {
    @JsonProperty("legajo")
    public int legajo;
    @JsonProperty("Nombre")
    public String Nombre;
    @JsonProperty("Apellido")
    public String Apellido;
}
