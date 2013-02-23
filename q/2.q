
files:.Q.dd[ `:Ergebnisrechnung] each `Ergebnis2009.txt`Ergebnis2010.txt

(::)ergebnis:update date:2009 from {flip `gschluessel`vwf`ndk`pdg`tdp`knt`tkt`val!("JJSJSJSF";";")0: x} files 0
(::)ergebnis1:update date:2010 from {flip `gschluessel`vwf`ndk`pdg`tdp`knt`tkt`val!("JJSJSJSF";";")0: x} files 1

(::)ergebnis:ergebnis,ergebnis1

update bew:`einnahmen from `ergebnis where knt within (400 499)
update bew:`ausgaben from `ergebnis where knt within (500 599)
update bew:`einnahmen from `ergebnis where knt within (4000 4999)
update bew:`ausgaben from `ergebnis where knt within (5000 5999)

update kontenart:{parse 3#x}each string[knt] from `ergebnis

(::)bev:("SSSSSSSSFFFFFFSSSSSS";"; ")0:`bev.csv

f:{x:parse "." sv "," vs x;$[-9 = type x;x;0n]}

update lgrad:f each string lgrad from `bev

update bgrad:f each string bgrad from `bev  

update kreis:{ `$"" sv x} each flip (string Land;string RB;string Kreis) from `bev

bev:select from bev where not null insgesamt 

bev:select bevoelkerung:sum insgesamt,lgrad:avg lgrad,bgrad:avg bgrad by kreis from bev

update kreis:{`$5#x} each string gschluessel from `ergebnis

ergebnis:update bkreis:ndk from ergebnis where vwf in 1 5

tmp:`kreis xkey select first distinct bkreis by kreis from ergebnis where vwf=5

update bkreis:tmp[;`bkreis] each kreis from `ergebnis where vwf =2 

update kreis: {`$last[t],-1_t:string x} each kreis from `ergebnis

erg1:select val:sum val,first bkreis,first tdp by date,kreis,pdg,bew from ergebnis

erg2:erg1 lj `kreis xkey bev










