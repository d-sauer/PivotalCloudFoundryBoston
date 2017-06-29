# PCF Playground

## Local Dev setup

1. https://docs.pivotal.io/pcf-dev/ 
2. Install CLI: https://docs.pivotal.io/pivotalcf/1-11/cf-cli/install-go-cli.html
    a. CLI cheat sheet: https://blog.anynines.com/wp-content/uploads/2016/05/a9s-CF-Cheat-Sheet.pdf
3. PCF Dev
    a. https://docs.pivotal.io/pcf-dev/
    b. Download: https://network.pivotal.io/products/pcfdev


    cf login -a https://api.local.pcfdev.io --skip-ssl-validation

Apps Manager URL: https://local.pcfdev.io

Admin user => Email: admin / Password: admin

Regular user => Email: user / Password: pass



### PCF Dev Offline

https://docs.pivotal.io/pcf-dev/work-offline.html

1. Install dnsmasq
2. Start dnsmasq

        sudo brew services start dnsmasq
        
   List services
   
        sudo brew services list
        
3. Redirect _local.pcfdev.io_ to the IP _192.168.11.11_ (VirtualBox)
        
        echo "address=/.local.pcfdev.io/192.168.11.11" >> /usr/local/etc/dnsmasq.conf

4. Restart dnsmasq service

        sudo launchctl stop homebrew.mxcl.dnsmasq
        sudo launchctl start homebrew.mxcl.dnsmasq
        
5. Add _127.0.0.1_ as first DNS server


### Tooling

 - [Maven/Gradle PCF plugin](https://content.pivotal.io/blog/improved-java-tooling-for-cloud-foundry)
 

# Tiles

http://docs.pivotal.io/tiledev/tile-generator.html

Tile Generator installation: http://docs.pivotal.io/tiledev/tile-generator.html#how-to  
  

# Debug

For debugging we need to open SSH tunnel (5005 - port on localhost machine to connect remote debugger, Debug 8000 port on PCF):

    cf ssh -N -T -L 5005:localhost:8000 <APP_NAME>