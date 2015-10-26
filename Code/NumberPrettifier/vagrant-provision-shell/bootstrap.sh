#!/usr/bin/env bash
#sed -i 's/^mesg n$/tty -s \&\& mesg n/g' /root/.profile

sudo su

#echo "export http_proxy=http://ccarrascal:123Asdqwe@proxy.indra.es:8080" > /etc/profile.d/proxy.sh
#echo "export https_proxy=http://ccarrascal:123Asdqwe@proxy.indra.es:8080" >> /etc/profile.d/proxy.sh
#source /etc/profile.d/proxy.sh

# Variables
APPENV=local


echo -e "\n--- Mkay, installing now... ---\n"

echo -e "\n--- Updating packages list ---\n"
apt-get -qq update

echo -e "\n--- Install base packages ---\n"
apt-get -y install vim curl build-essential git # > /dev/null 2>&1

echo -e "\n--- Updating packages list ---\n"
apt-get -qq update

echo -e "\n--- Install MySQL specific packages and settings ---\n"
echo "mysql-server mysql-server/root_password password $DBPASSWD" | debconf-set-selections
echo "mysql-server mysql-server/root_password_again password $DBPASSWD" | debconf-set-selections
echo "phpmyadmin phpmyadmin/dbconfig-install boolean true" | debconf-set-selections
echo "phpmyadmin phpmyadmin/app-password-confirm password $DBPASSWD" | debconf-set-selections
echo "phpmyadmin phpmyadmin/mysql/admin-pass password $DBPASSWD" | debconf-set-selections
echo "phpmyadmin phpmyadmin/mysql/app-pass password $DBPASSWD" | debconf-set-selections
echo "phpmyadmin phpmyadmin/reconfigure-webserver multiselect none" | debconf-set-selections
apt-get -y install ant openjdk-7-jdk
