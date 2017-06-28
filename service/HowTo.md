# Creating service with BOSH

## Install BOSH CLI (2.x.x)

BOSH CLI install
  - https://bosh.io/docs/cli-v2.html
  - https://github.com/cloudfoundry/homebrew-tap
  
  
## Create service

1. Enter service release folder (**root**, e.g. service/activemq-service)

2. Initialize the release `bosh init-release`


    activemq-service
      (root)
        ├── config
        │   ├── blobs.yml
        │   └── final.yml
        ├── jobs
        ├── packages
        └── src
    
> Best Practice: <br/>
   Use - (dash) in the release name, <br/>
   and _ (underscores) in all the files in the release
   
3. Generate job for ActiveMq server `bosh generate-job activemq_server`


    .
    ├── config
    │   ├── blobs.yml
    │   └── final.yml
    ├── jobs
    │   └── activemq_server
    │       ├── monit
    │       ├── spec
    │       └── templates
    ├── packages
    └── src
    
    
4. Create start (`start.erb`) script for the ActiveMq server in _service/activemq-service/jobs/activemq_server/templates_
5. Create start (`stop.erb`) script for the ActiveMq server in _service/activemq-service/jobs/activemq_server/templates_
5. Fill in monitoring (`monit`) script _service/activemq-service/jobs/activemq_server/monit_
6. Fill in specification (`spec`) script _service/activemq-service/jobs/activemq_server/spec_
  
7. Download ActiveMq `curl -o apache-activemq-5.9.1-bin.tar.gz http://apache.mesi.com.ar/activemq/5.14.4/apache-activemq-5.14.4-bin.tar.gz`

8. Generate BOSH package *activemq_pkg*: `bosh generate-package activemq_pkg`
>    This will add *activemq_pkg* to the *packages* folder, with *packaging* and *spec* file.
 
 
9. Add which files to include in the package (*packages/activemq_pkg/spec*)


    ---
    name: activemq_pkg
    
    dependencies: []
    
    files:
      - activemq.tar.gz
      
      
10. Create BOSH deployment manifest _service/activemq-service/manifest/activemq.yml_

11. Create BOSH release `bosh create-release --force --tarball=activemq-release`

12. Copy release to the server `scp -i ../../../PCFBostonWorkshop/pie-27.pem activemq-release ubuntu@opsman.pie-27.cfplatformeng.com:~/activemq/`

13. Copy manifest (_activemq.yml_) to the server `scp -i ../../../PCFBostonWorkshop/pie-27.pem manifest/activemq.yml ubuntu@opsman.pie-27.cfplatformeng.com:~/activemq/`

14. BOSH deployment: `bosh deployment <copied manifest file..acivemq.yml>`

15. BOSH deploy `bosh deploy`