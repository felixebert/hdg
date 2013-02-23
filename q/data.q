
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
ergebnis:select from ergebnis where pdg within 252 299
ergebnis:update bkreis:ndk from ergebnis where vwf in 1 5

tmp:`kreis xkey select first distinct bkreis by kreis from ergebnis where vwf=5

update bkreis:tmp[;`bkreis] each kreis from `ergebnis where vwf =2 

update kreis: {`$last[t],-1_t:string x} each kreis from `ergebnis

erg1:select val:sum val,first bkreis,first tdp by date,kreis,pdg,bew from ergebnis

erg2:() xkey erg1 lj `kreis xkey bev

update ausgaben:val%bevoelkerung from `erg2 where bew = `ausgaben

erg2:select from erg2 where not null bevoelkerung

tab1:5#`ausgaben xdesc ()xkey select ausgaben:sum ausgaben,first bkreis by kreis from erg2 where date = 2009
dat1:exec kreis from 5#`ausgaben xdesc ()xkey select ausgaben:sum ausgaben,first bkreis by kreis from erg2 where date = 2009
tab2:select from erg2 where kreis in dat1,bew = `ausgaben

.z.ws:{neg[.z.w] -8!value x}

/

ergebnis


update bew:`einnahmen from `ergebnis where knt within (400 499)
update bew:`ausgaben from `ergebnis where knt within (500 599)
update bew:`einnahmen from `ergebnis where knt within (4000 4999)
update bew:`ausgaben from `ergebnis where knt within (5000 5999)

update kontenart:{parse 3#x}each string[knt] from `ergebnis

update gschluessel:{`$last[t],-1_t:string x}each gschluessel from `ergebnis

(::)bev:("SSSSSSSSFFFFFFFSSSSS";"; ")0:`bev.csv

(::)bev:select from bev where not null insgesamt

`gschluessel xcols update gschluessel:{ `$"" sv x} each flip (string RB;string RB;string VB;string Gem) from bev
bev
ergebnis
endtable:ergebnis lj `gschluessel xkey bev

100#endtable


select from ergebnis where knt within 0 999

select count i  by ndk from ergebnis 

(::)bg:select from ergebnis where ndk =`$"Bergisch Gladbach"

select by gschluessel from ergebnis

select by knt from ergebnis






100#ergebnis
`cnt xdesc select cnt:sum val by knt from ergebnis
select i,val from ergebnis where knt = 4182
(::)ergebnis:flip ((`$)each .Q.A[ til count[r]])
(::)ergebnis:flip`ams`vwf`ndk`pdg`tdp`knt`tkt`value!r:("SSSSSSSSS";";")0: `:Ergebnisrechnung/Ergebnis2009.txt


