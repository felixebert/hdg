

files:.Q.dd[ `:Ergebnisrechnung] each `Ergebnis2009.txt`Ergebnis2010.txt

(::)ergebnis:update date:2009 from {flip `gschluessel`vwf`ndk`pdg`tdp`knt`tkt`val!("JJSJSJSF";";")0: x} files 0
(::)ergebnis1:update date:2010 from {flip `gschluessel`vwf`ndk`pdg`tdp`knt`tkt`val!("JJSJSJSF";";")0: x} files 1

ergebnis:ergebnis,ergebnis1

(::)bilanz:flip `gschluessel`vwf`ndk`sig`tsg`val!("SSSSSS";";")0:`:Bilanzen/bilanz.txt

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


