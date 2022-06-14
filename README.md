# Squad 5 · Módulo de Recursos

### Deploy
Para hacer un deploy de la aplicación a producción, es necesario tener una cuenta en [Heroku](https://www.heroku.com/).

Una vez creada la cuenta y siendo colaboradores del proyecto en Heroku, 
debemos instalar el [CLI de heroku](https://devcenter.heroku.com/articles/heroku-cli#install-the-heroku-cli)
y loggearnos.
```bash
$ heroku login
```

Una vez realizado este paso, agregamos el remote de heroku a nuestro repositorio git
```bash
$ heroku git:remote -a squad5-recursos
```

Ahora, cada vez que queremos hacer un deploy, alcanza con pushear los cambios ya commiteados
a la rama `master` del repositorio de heroku
```bash
$ git add .
$ git commit -m "Deploying"
$ git push heroku master
...
remote: Building source:
remote: 
remote: -----> Building on the Heroku-20 stack
remote: -----> Using buildpack: heroku/gradle
remote: -----> Gradle app detected
...
remote:        Released v1
remote:        https://squad5-recursos.herokuapp.com/ deployed to Heroku
remote: 
remote: Verifying deploy... done.
```

Podemos monitorear el deploy viendo los logs de esta forma
```bash
$ heroku logs --tail
```
