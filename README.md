# Test_Vagrant_Solr

* Last ned Vagrant (https://www.vagrantup.com/downloads.html)
* Klon dette prosjektet
* cd til mappen
* 'vagrant up' i terminal => La den jobbe seg ferdig. Dette lager en virtuell maskin som har Solr og slikt installert.
* 'vagrant ssh' for å komme seg inn i VM'en.
* 'cd ..' to ganger
* 'cd vagrant'
* 'cd Solr'
* './deploySolrNode' => Kommer til å jobbe ganske lenge. Når den slutter å spy ut nye linjer:
* 'http://localhost:8983/solr' i nettleseren


* Parser.java => Her må vi få laget en flott parser som kan ta seg av å det å lese filene. Formatet er kjempefucka, så det det sliter hodet mitt mde.

* Test_1.java => Mainmetoden her klarer å stappe ting inn i en kjørende Solr-node.

* Dashboard: Klikk på Core selector => Collection 1 => Query, så kan man søke etter ting eller alt eller whatever.
