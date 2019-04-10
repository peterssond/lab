Dessa är enbart tillgängliga via den separata webservern som sätts upp för management. Behöver inget filter då de inte finns på de andra connectorerna.
Det smidigaste hade varit om vi hade kunnat hålla oss helt till denna webserver för interna tjänster då vi då inte behöver något filter och faktiskt är helt isolerade bakom routern.
Jag har dock inte hittat någon lösning på CXF gränssnitt för denna webserver, så om det är ett krav att intern trafik går med TK så måste vi nog köra på en av 
http://localhost:8070/admin/normaltest
http://localhost:8070/admin/resttest/test1
http://localhost:8070/admin/resttest/test2
http://localhost:8070/admin/servlettest

Detta skall föreställa externa APIer som kan vara tillgängliga på både den interna 8060 porten men även den externa. Dessa behöver inget filter
http://localhost:8080/api/test
http://localhost:8060/api/test

Detta skall föreställa interna APIer som enbart skall vara tillgängliga på den interna 8060 porten. Denna behöver ett filter som förhindrar åtkomst på 8080 eftersom 8060 enbart är en extra connector på samma webserver.
http://localhost:8080/internalapi/test
http://localhost:8060/internalapi/test