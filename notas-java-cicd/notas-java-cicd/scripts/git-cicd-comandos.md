# Comandos Git para CI/CD del caso Notas Java

## 1. Crear repositorio local

```bash
git init
git branch -M main
```

**Explicación:**
- `git init`: crea un repositorio Git local.
- `git branch -M main`: renombra la rama principal a `main`, rama que representará producción.

## 2. Registrar primera versión en main

```bash
git add .
git commit -m "chore: estructura inicial del laboratorio CI CD"
```

**Explicación:**
- `git add .`: prepara todos los archivos para el commit.
- `git commit -m`: guarda una versión del proyecto con un mensaje descriptivo.

## 3. Conectar con GitHub

```bash
git remote add origin https://github.com/USUARIO/notas-java.git
git push -u origin main
```

**Explicación:**
- `git remote add origin`: vincula el repositorio local con GitHub.
- `git push -u origin main`: sube la rama `main` y deja configurado el seguimiento remoto.

## 4. Crear rama develop para trabajo de desarrollo

```bash
git checkout -b develop
git push -u origin develop
```

**Explicación:**
- `git checkout -b develop`: crea y cambia a la rama `develop`.
- `git push -u origin develop`: sube la rama de desarrollo a GitHub.

## 5. Simular versión 1: programa sin validación

```bash
cp docs/Main_v1.java src/Main.java
git add src/Main.java
git commit -m "feat: version 1 calcula promedio sin validacion"
git push origin develop
```

**Efecto CI:** al hacer `push` a `develop`, GitHub Actions ejecuta `.github/workflows/ci.yml`.

## 6. Simular versión 2: validación de notas

```bash
cp docs/Main_v2.java src/Main.java
git add src/Main.java
git commit -m "feat: version 2 valida notas entre 0 y 20"
git push origin develop
```

**Efecto CI:** se vuelve a ejecutar compilación y pruebas sobre la rama `develop`.

## 7. Simular versión 3: promedio decimal

```bash
cp docs/Main_v3.java src/Main.java
git add src/Main.java
git commit -m "feat: version 3 calcula promedio decimal con double"
git push origin develop
```

**Efecto CI:** se valida la versión final antes de pasar a QA.

## 8. Crear Pull Request de develop hacia main

Desde GitHub:
1. Ir al repositorio.
2. Clic en **Pull requests**.
3. Clic en **New pull request**.
4. Base: `main`; compare: `develop`.
5. Crear Pull Request.
6. QA revisa el código y verifica que CI esté en verde.

También puede hacerse con GitHub CLI:

```bash
gh pr create --base main --head develop --title "QA: liberar version final" --body "Se valida la version 3 para produccion."
```

## 9. Merge a producción

Desde GitHub, después de aprobar QA:

```bash
gh pr merge --merge
```

O manualmente en consola:

```bash
git checkout main
git pull origin main
git merge develop
git push origin main
```

**Efecto CD:** al hacer `push` a `main`, GitHub Actions ejecuta `.github/workflows/cd.yml`, compila el programa y genera el artefacto `notas-java.jar`.

## 10. Probar localmente

```bash
javac -d out src/Main.java test/MainTest.java
java -ea -cp out MainTest
java -cp out Main
```

**Explicación:**
- `javac -d out`: compila y envía los `.class` a la carpeta `out`.
- `java -ea`: ejecuta las pruebas activando `assert`.
- `java -cp out Main`: ejecuta el programa principal.
