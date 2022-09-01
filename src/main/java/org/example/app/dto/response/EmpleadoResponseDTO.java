package org.example.app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoResponseDTO extends PersonaResponseDTO{

        private String legajo;
        private String cargo;
/*
        public EmpleadoResponseDTO(String nombre, String apellido, String dni, String legajo, String cargo) {
            super(nombre, apellido, dni);
            this.legajo = legajo;
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return "Empleado{" +
                    "legajo='" + legajo + '\'' +
                    ", cargo='" + cargo + '\'' +
                    ", nombre='" + nombre + '\'' +
                    ", apellido='" + apellido + '\'' +
                    ", dni='" + dni + '\'' +
                    '}';
        }
        */
}
