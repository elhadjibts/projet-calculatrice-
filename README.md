# projet-calculatrice-
Calculatrice statique et Calculatrice Dynamique 
fndef::imagesdir[:imagesdir: ./images]

= Découverte Struts

== Mettre en place son projet(je te modifie )

. *Installez le plugin Struts2* si vous avez la dernière version d'IntellIJ. *Relancez votre IDE*.
. Créez un projet maven vide dont le groupeId sera *fr.univ.orleans.pnt* et l'artifactId *decouvertestruts*.
. Faites les modifications de votre *pom.xml* afin d'obtenir celui donné à la fin de cette page (*packaging, properties, dependencies et plugins*). *Pensez à mettre à jour maven* avec les flêches qui tournent ;)

. Tout comme pour les JSP/servlets, avec *"Project Structure"*, générez le dossier *webapp*, le *web.xml*. Modifiez également votre *web.xml* en intégrant les filtres liés à Struts

. Créez un ficher *struts.xml* à la racine du dossier resources puis copier/coller le contenu du fichier struts.xml à la fin de ce sujet

. Une fois fini l'étape 5, une info bulle devrait apparaître pour configurer le framework struts 2. Cliquez dessus et rendez vous à l'étape 9. Si ce n'est pas le cas passez à l'étape 7

. Allez sur *"Projet Structure" > Modules* et sélectionnez Web qui devrait apparaître sous pelstruts

. Cliquez sur le petit + en haut à droite de la même zone et sélectionnez Struts 2.
. Normalement vous devriez avoir un File Sets vide sur la droite de la fenêtre de configuration

image:fileset.png[]
[start=10]
. Cliquez sur + et sélectionnez toutes cases proposées
. Créez votre *pageAccueil.jsp* en respectant le chemin  */WEB-INF/pages/pageAccueil.jsp*



.Pour compléter le pom.xml
[source, xml]
----
<packaging>war</packaging>

  <properties>
        <maven.compiler.target>11</maven.compiler.target>
        <maven.compiler.source>11</maven.compiler.source>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
 </properties>
     <dependencies>
        <dependency>
            <groupId>org.apache.struts</groupId>
            <artifactId>struts2-core</artifactId>
            <version>2.5.20</version>
        </dependency>
    </dependencies>
<build>
  <plugins>
      <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>3.8.1</version>
          <configuration>
              <release>11</release>
              <encoding>UTF-8</encoding>
          </configuration>
      </plugin>
      <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-war-plugin</artifactId>
          <version>3.2.3</version>
          <configuration>
              <failOnMissingWebXml>false</failOnMissingWebXml>
          </configuration>
      </plugin>
      <plugin>
          <groupId>org.eclipse.jetty</groupId>
          <artifactId>jetty-maven-plugin</artifactId>
          <version>9.4.25.v20191220</version>
      </plugin>
  </plugins>
</build>
----

.Le web.xml
[source, xml]
----
<filter>
    <filter-name>struts2</filter-name>
    <filter-class>org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter</filter-class>
</filter>

<filter-mapping>
    <filter-name>struts2</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
----

.Le struts.xml
[source, xml]
----
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE struts PUBLIC
        "-//Apache Software Foundation//DTD Struts Configuration 2.5//EN"
        "http://struts.apache.org/dtds/struts-2.5.dtd">
<struts>
    <constant name="struts.devMode" value="true" />
    <constant name="struts.enable.DynamicMethodInvocation" value="false"/>

    <package name="default" namespace="/" extends="struts-default">

        <default-action-ref name="accueil"/>
        <action name="accueil">
            <result>/WEB-INF/pages/pageAccueil.jsp</result>
        </action>
    </package>

</struts>
----


== Premiers pas

. Créez dans un premier temps un *menu avec trois liens* le premier lien vous emmènera vers une page connexion. Le deuxième vers une calculatrice statique et le troisième vers une calculatrice dynamique. Cet exercice nécessite de créer trois actions et chaque action vous guidera vers une JSP cible : *connexion.jsp, calculatriceStatique.jsp et calculatriceDynamique.jsp*.
Vérifiez si vos redirections sont fonctionnelles en exécutant via jetty.
. Dans la *connexion.jsp*, définissez un formulaire contenant deux champs et un bouton de validation : un champ de type textfield que nous nommerons pseudo et un champ de type password que nous nommerons motSecret. Le but de cet exercice est de transmettre les informations saisies vers une page infosSaisies.jsp.
Vous devrez *définir une action Saisie.java* dans un *package actions* avec deux champs de type String nommés comme les champs sur la jsp source. Une *action doit étendre la classe ActionSupport* proposée par Struts 2.
.. Pour les deux champs, *générer les getters/setters*
.. *Définissez la méthode String execute()* en changeant le retour i.e. INPUT. Quelle erreur constatez vous au moment de valider le formulaire ?
.. *Changez le fichier struts.xml* pour qu'en cas de succès, l'action précédente vous redirige effectivement sur la page cible par contre, si le mot de passe ou le login fait (font) moins de 3 caractères, alors on reste bloqué sur la page courante.
.. Avec *addFielError(String nomChamp, String messageErreur)*  précisez les erreurs obtenues.
.. Sur la page *infosSaisies.jsp*, faites apparaître les deux informations saisies précédemment
. *Internationalisation* : Avant toute chose, créez un *fichier de properties* dans resources (mesTextes.properties) et le *déclarer dans struts.xml* (*<constant name="struts.custom.i18n.resources" value="mesTextes"/>*). Il est utilse aussi de préciser l'encodage des caractères (*<constant name="struts.i18n.encoding" value="UTF-8" />*).
*Déclarez tous vos textes dans ce fichier* en associant une clé à chaque texte. Par exemple : pageAccueil.titre = Page d'accueil. Ainsi dans les jsps, vous pouvez référer ces textes en utilisant la balise <s:text .../>. Pour les champs de formulaire, vous pouvez aussi utiliser les paramètres key. Mettez à jour toutes vos JSPs. *Une belle JSP est une JSP dans laquelle il n'y a aucun texte en dur !!!*
. Pour la *calculatrice statique*, vous allez définir un formulaire contenant deux textfields et une liste déroulante que nous nommerons respectivement operande1, operande2 et operation. La liste déroulante devra contenir les 4 chaînes de caractères suivantes : "somme", "soustraction", "division" et "multiplication". Le but du jeu sera d'arriver sur une page "resultat" et d'afficher le résultat de l'opération définie : operande1 operation operande2
. Pour la calculatrice dynamique, nous allons nous aider d'un modèle qui propose la gestion de certaines opérations binaires. Le modèle est essentiellement composé d'une interface CalculatriceDynamiqueDuFutur et de sa classe "fille". Nous devrons avoir une page similaire à celle de la calculatrice statique sauf que la liste des opérations sera dans ce cas dynamique (vous avez deux versions du modèle à tester). De plus nous voulons afficher sur la page résultat le nombre d'utilisations de la calculatrice (qui est stocké dans le modèle) : 
modele 1.0 et modele 2.0 (donnés dans le dossier *modeles* que vous devez installer avec maven mvn install pour chaque modèle. Vous devrez également ajouter la dépendance de la calculatrice dans votre projet struts). Sur la page résultat nous voulons également affichées la liste complète de toutes les opérations gérées par la calculatrice dynamique
. Ajoutez une 4e lien au menu qui nous mènera vers une page *listeEtudiant.jsp*. Pour ceci vous devrez installer le modele suivant : *modeleetudiant*. Après avoir installé ce modèle très léger, l'idée va être d'afficher sur la page listeEtudiant.jsp tous les étudiants inscrits par défaut dans ce modèle (en utilisant la méthode getEtudiants() offerte par l'unique façade contenant une unique fonction). Sur la jsp, vous devrez afficher le détails de chaque étudiant dans une liste de puces en utilisant la balise struts : s:iterator. _Les éléphants sont taquins et vieux..._
