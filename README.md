# Módulo de Criptografía

## Servicios de Firma Electrónica
- OCSP
- TSP
- FIRMA


## Configuración
### Variables
src/main/resources/application.properties


## Depuración
### Modo local - InteliJ
- Compilador IntelliJ Idea.
  Debug TableroFirmasAplicación

### Modo local - Postman
Environments
url_1_seguridad = http://127.0.0.1:8082
GET /api/v/

- Test servicios POSTMAN
  Test GET /api/version
- Test /documentos-usuario



## Compilación

## Despliegue
- [ ] Limpiar el artefacto
- [ ] Renombrar para la webapp 'firma-pki'






# firma-electronica



## Getting started

To make it easy for you to get started with GitLab, here's a list of recommended next steps.

Already a pro? Just edit this README.md and make it your own. Want to make it easy? [Use the template at the bottom](#editing-this-readme)!

## Add your files

- [ ] [Create](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#create-a-file) or [upload](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#upload-a-file) files
- [ ] [Add files using the command line](https://docs.gitlab.com/ee/gitlab-basics/add-file.html#add-a-file-using-the-command-line) or push an existing Git repository with the following command:

```
cd existing_repo
git remote add origin https://gitlab.com/tribunal-electoral/firma-electronica.git
git branch -M main
git push -uf origin main
```
