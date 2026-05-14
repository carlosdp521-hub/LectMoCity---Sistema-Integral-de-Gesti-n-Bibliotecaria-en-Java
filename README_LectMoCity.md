# 📚 LectMoCity - Sistema Integral de Gestión Bibliotecaria en Java

Sistema desarrollado en Java para la administración de bibliotecas municipales, aplicando Programación Orientada a Objetos (POO), arquitectura MVC y múltiples patrones de diseño.

El proyecto fue desarrollado como solución para la problemática planteada por la biblioteca municipal **LectMoCity Libros** de MoronCity.

---

# 🚀 Características principales

✅ Registro de libros físicos  
✅ Registro de libros digitales  
✅ Registro de usuarios  
✅ Gestión de préstamos y devoluciones  
✅ Control de estados de libros  
✅ Notificaciones automáticas de inventario  
✅ Control de acceso mediante roles  
✅ Arquitectura MVC  
✅ Aplicación de patrones de diseño  
✅ Interfaz gráfica Java Swing  
✅ Compatible con VS Code y Eclipse  

---

# 🧠 Patrones de diseño implementados

| Patrón | Implementación |
|---|---|
| Singleton | `ConexionBD`, `GestorPrestamos` |
| Adapter | `AdaptadorLibroDigital` |
| Observer | `InventarioObservable` |
| State | `EstadoDisponible`, `EstadoPrestado`, `EstadoReservado` |
| Strategy | `CalculoFechaEstudiante`, `CalculoFechaDocente` |
| Proxy | `ControlAccesoAdministrador` |
| MVC | Modelo - Vista - Controlador |

---

# 📂 Estructura del proyecto

```text
LectMoCity/
│
├── src/
│   └── lectmocity/
│       ├── Main.java
│       │
│       ├── modelo/
│       ├── vista/
│       ├── controlador/
│       └── patrones/
│
└── README.md
```

---

# 🖥️ Tecnologías utilizadas

- Java JDK 17+
- Java Swing
- Programación Orientada a Objetos
- Arquitectura MVC
- Patrones de diseño GoF

---

# ⚙️ Requisitos

- Java JDK 17 o superior
- Visual Studio Code o Eclipse

---

# ☕ Instalación de Java

https://www.oracle.com/java/technologies/downloads/

Verificar instalación:

```bash
java -version
```

---

# 🖥️ Ejecutar en Visual Studio Code

1. Instalar VS Code
2. Instalar Extension Pack for Java
3. Abrir carpeta LectMoCity
4. Ejecutar Main.java

---

# 🖥️ Ejecutar en Eclipse

1. Crear proyecto Java
2. Copiar carpeta src
3. Ejecutar Main.java

---

# 🧩 Funcionalidades del sistema

## 📚 Gestión de libros

- Registrar libros físicos
- Registrar libros digitales
- Consultar catálogo
- Visualizar estados

## 👤 Gestión de usuarios

- Registrar estudiantes
- Registrar docentes

## 🔄 Gestión de préstamos

- Prestar libros
- Devolver libros
- Registrar fechas automáticas

## 🔔 Observer

Notificación automática de cambios en inventario.

## 🔐 Proxy

Control de acceso por roles.

---

# 👨‍💻 Autor

Carlos Di Piazza  
Instituto Profesional IACC

GitHub:
https://github.com/carlosdp521-hub

---

# 📚 Bibliografía

Gamma, E., Helm, R., Johnson, R., & Vlissides, J. (1994). Design patterns: Elements of reusable object-oriented software. Addison-Wesley.

Refactoring.Guru. Patrones de diseño:
https://refactoring.guru/es/design-patterns

---

# ✅ Estado del proyecto

🟢 FUNCIONAL  
🟢 COMPILABLE  
🟢 EJECUTABLE  
🟢 LISTO PARA EVALUACIÓN ACADÉMICA
