# Laboratorio CI/CD con GitHub Actions - Programa de Notas en Java

## Objetivo

Simular un flujo CI/CD donde un programa Java evoluciona en tres versiones:

1. Versión 1: calcula el promedio de tres notas sin validar el rango.
2. Versión 2: valida que las notas estén entre 0 y 20.
3. Versión 3: cambia el promedio de `int` a `double` para conservar decimales.

El flujo usa dos ramas principales:

- `develop`: desarrollo e integración continua.
- `main`: producción y despliegue continuo.

## Estructura del proyecto

```text
notas-java-cicd/
├── .github/
│   └── workflows/
│       ├── ci.yml
│       └── cd.yml
├── src/
│   └── Main.java
├── test/
│   └── MainTest.java
├── docs/
│   ├── Main_v1.java
│   ├── Main_v2.java
│   └── Main_v3.java
├── scripts/
│   └── git-cicd-comandos.md
├── .gitignore
└── README.md
```

## CI: Integración Continua

Archivo: `.github/workflows/ci.yml`

Se ejecuta cuando hay:

- `push` a `develop`.
- `pull_request` hacia `develop` o `main`.

Acciones realizadas:

1. Clona el repositorio.
2. Instala JDK 17.
3. Compila `src/Main.java` y `test/MainTest.java`.
4. Ejecuta las pruebas con `assert` habilitado.

## CD: Despliegue Continuo

Archivo: `.github/workflows/cd.yml`

Se ejecuta cuando hay:

- `push` a `main`.
- Ejecución manual con `workflow_dispatch`.

Acciones realizadas:

1. Clona el repositorio.
2. Instala JDK 17.
3. Compila el programa final.
4. Genera el archivo `notas-java.jar`.
5. Publica el artefacto en GitHub Actions.

## Flujo de trabajo recomendado

1. El programador trabaja en `develop`.
2. Cada cambio en `develop` activa CI.
3. QA revisa el Pull Request de `develop` hacia `main`.
4. Si QA aprueba, se hace merge a `main`.
5. El merge activa CD y genera el artefacto de producción.

## Comandos detallados

Revisar:

```text
scripts/git-cicd-comandos.md
```

## Prueba local

```bash
javac -d out src/Main.java test/MainTest.java
java -ea -cp out MainTest
java -cp out Main
```
