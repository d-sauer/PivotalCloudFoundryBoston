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
  