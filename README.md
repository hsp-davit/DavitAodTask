# Architecture.

Ծրագրում class-ները դասավորված են համապատասխան package-ներում,որը ապահովում է "SRP" object oriented design principle-ը։  

staff package-ում առկա են աշխատակազմին վերաբերվող կլասսները։

Աշխատակիցների համար նախատեսել եմ ունենալ մեկ հիմնական աբստրակցիա "Member" class-ի միջոցով։ 
Բոլոր աշխատակիցները ժառանգված կլինեն "Member" abstract class-ից։ 

"Member" abstract class-ի մեջ պահել եմ Enum տիպի փոփոխական,որն արժեքավորել եմ համապատասխան class֊ների constructor֊ների մեջ,որը հնարավորություն կտա իմանալ տրված Member֊ը կարող է լինել supervisor թե ոչ։

factory package-ը նախատեսված է Member type հանդիսացող ժառանգ class֊ների օբյեկտների ստեղծումը ինկապսուլացնելու համար։

util package-ում առկա են Date և Math utility class֊ները, որոնք նախատեսված են մեթոդներ տրամադրելու համար։

exception package-ում առկա են համապատասխան Exception class֊ները։

Ծրագրի ֆունկցիոնալը ստուգված է JUnit test֊երով, որոնք առկա են MemberTest և CopmanyTest class-ներում։

Ծրագրում CompanyDemo class-ը նախատեսված է հաշվելու աշխատակիցների աշխատավարձը։

# Ինչպես կառուցել եւ գործարկել ծրագիրը:

1. Ծրագիրը իրենից ներկայացնում է Maven project․

2. Ծրագիրը Build անելու և JUnit Test-երը աշխատացնելու համար անհրաժեշտ է կիրառելհետևյալ հրամանը։ 
mvn clean package

3. Ծրագիրը աշխատացնելու համար հարկավոր է կիրառել java -jar հրամանը ood-jar-with-dependencies.jar target folder-ի մեջ (terminal-ում)

java -jar ood-jar-with-dependencies.jar