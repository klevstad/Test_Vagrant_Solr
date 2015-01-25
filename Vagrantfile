# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant::Config.run do |config|
  config.vm.box = "virtualUbuntu64"

  config.vm.box_url = "http://files.vagrantup.com/precise64.box"
  config.vm.provision :shell, :inline => "sudo apt-get update"
  config.vm.provision :shell, :inline => "sudo apt-get install curl -y"
  config.vm.provision :shell, :inline => "sudo apt-get install vim -y"
  

  config.vm.provision :shell, :inline => "curl -s https://get.docker.io/ubuntu/ | sudo sh > /dev/null 2>&1"

  config.vm.forward_port 5002, 5000 # HealthKitServer
  config.vm.forward_port 8984, 8983 # Solr 8983
  config.vm.forward_port 6378, 6379 # Redis 6379
  config.vm.forward_port 3307, 3306 # MySQL 3306
end

Vagrant.configure("2") do |config|

config.vm.provider :virtualbox do |virtualbox|
            
virtualbox.customize ["modifyvm", :id, "--memory", "1024"]     
                 
end
end
