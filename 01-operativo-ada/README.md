# Operativo ADA — Repaso de programación en Java

Proyecto de consola realizado como repaso general de conceptos de Java durante el primer curso de DAM.

## 📌 Descripción

El proyecto simula una operación policial contra cyborgs e integra varios conceptos fundamentales de programación orientada a objetos. Se ha mantenido la estructura original del ejercicio y se han realizado únicamente mejoras simples de organización para poder presentarlo dentro del repositorio `java-fundamentals`.

## 🧠 Conceptos trabajados

- Clases y objetos
- Herencia
- Interfaces
- Clases abstractas
- Arrays y `ArrayList`
- `HashMap`
- Bucles y condicionales
- Métodos estáticos
- Organización mediante paquetes
- Menús por consola

## 📁 Estructura

```text
01-operativo-ada/
├── src/
│   ├── entrenamiento/
│   ├── general/
│   ├── mensajes/
│   ├── operaciones/
│   └── recursos/
├── build.xml
├── manifest.mf
└── README.md
```

## ▶️ Ejecución

El proyecto puede abrirse directamente con NetBeans. También se puede compilar desde terminal entrando en la carpeta del proyecto:

```bash
javac -d out $(find src -name "*.java")
java -cp out operaciones.Menu
```

En Windows PowerShell, si el comando anterior no funciona, es recomendable ejecutarlo desde NetBeans.

## ✅ Mejoras aplicadas

- Limpieza de archivos compilados y carpetas generadas.
- Conservación del código fuente original.
- Documentación del proyecto para facilitar su revisión en GitHub.
- Inclusión dentro de una estructura de portfolio más clara.
