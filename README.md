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


* Populator.java => Leser alle filene fra Part1-mappen og kaller parseren på hver fil. Mapper NSF-dokumentet til et Solr-dokument og poster det til Solr-noden.

* Parser.java => Parser en tekstfil på en stygg måte ut ifra det formatet vi har og pakker det inn i vårt eget NSF-objekt.

* Searcher.java => Lettvekter av en søkemetode. Putt inn et "google query" i setFilter(...) så søker den i det som er postet til Solr-noden.

* Nettleser/Dashboard: Klikk på Core selector => Collection 1 => Query. Kan søke etter bestemte ting, eller hele "databasen" for å se at Populator.java fungerer for eksempel.
