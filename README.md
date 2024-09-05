# Introduction 
## University Research Chemicals Ordering System

Introduction
The University Research Chemicals Ordering System is designed to streamline the process of managing chemicals within research institutes and centers. This system replaces traditional paper-based methods with a web-based solution, aiming to improve efficiency, reduce risks associated with chemical handling, and enhance compliance with safety regulations. The system facilitates chemical requests, approvals, inventory management, and disposal, all within a user-friendly interface.

# Getting Started
## 1.	Installation process
To set up the University Research Chemicals Ordering System on your local machine, follow these steps:
Open terminal from the folder where you would like to clone the repo

    1. Clone the Repository:
    git clone https://github.com/flinders-cims/cims-api-backend-services.git
    2. Navigate to the Project Directory:
    cd <folder-name>
    3. mvn clean install for building the project
    4. Basic authentication is enabled as part of spring security. 
      - username  - admin
      - password - admin@1234
    5. Deploy the application in the local to see the changes, hit using postman by entering the url and adding basic authentication.
    
  <img width="999" alt="image" src="https://github.com/user-attachments/assets/af8a26cb-7249-421f-95b5-8c323267a0f4">

### Push Changes
#### Step 1: Create a branch from local

For all features developing create a feature branch like feature/'feature name'. For example, for login feature, the branch name should be 'feature/login'.
git checkout -b <feature/feature-name>

#### Step 2: Stage Your Changes

First, add the files you want to commit to the staging area. You can add all modified files or specific files:
- To add all modified files:
    git add .
- To add specific files:
    git add <file1> <file2> ...

#### Step 3: Commit Your Changes

- Once the files are staged, you can commit them with a meaningful commit message:
  
       git commit -m "Your descriptive commit message"

#### Step 3: Push Your Changes
After making some changes, if you want to push this new branch to your remote repository, you can use:

      git push origin feature-branch
      
#### Step 4: Create a pull request

Go to gitHub to create a pull request to merge branch changes to dev branch, would require code review and approvals to merge the code to the branch.

## 2. Software dependencies

- Java: JDK 17 or higher
- Spring Boot: 2.5.x or higher
- Maven: 3.6.x or higher
- MySQL: 8.x or higher (or compatible database)
- Postman to test locally

## 3. API References
API documentation is available through Swagger UI. Once the application is running, access it at:

Dev - https://flinders-cims-api-dev.azurewebsites.net/swagger.html
Test - https://flinders-cims-api-test.azurewebsites.net/swagger-ui.html

