From: Steve Jacobson <sjac3@leland.Stanford.EDU>
Subject: newly revised hw1b nightmare grammar
To: zelenski@CS.Stanford.EDU, sjac3@leland.Stanford.EDU, sjacobso@cisco.com
Date: Mon, 27 Apr 1998 13:05:09 -0700 (PDT)
X-Mailer: ELM [version 2.4 PL25]


The hw1b nightmare grammar (newly revised).

This was inspired by a fitful night of half-sleep before hw1b
was due.  I spent a very long evening writing the darray.c code,
and then had a segmentation fault I was too tired to track down.
I ended up debugging code all night in my sleep, dreaming about
the most bizarre and inconsequential things that could be wrong
(none of which were, of course).

SteveJ


{
<start> 
<code-phrase> <failure-reason> because it went <initial-pointer-problem>  So I ran it under gdb, but <gdb-problem>  So I tried Purify, which told me <purify-problem>  I've got to remember to <general-lament> 	
}

{
<code-phrase>
My <my-code-name> code			
My <my-code-name> code			
The example search code			
The <supplied-code-name> they gave us	
The provided <supplied-code-name>	
My <my-code-name> code			
My <my-code-name> code			
}

{
<my-files>
<my-code-name>		
<my-headers-name>	
}

{
<my-code-name>
DArray		
HashTable	
old scanner	
darray.c	
search.c	
hashtable.c	
old scanner.c	
}

{
<my-headers-name>
darray.h	
search.h	
hashtable.h	
old scanner.h	
}

{
<supplied-code-name>
scanner.o	
darray.o	
hashtable.o	
old scanner.c	
}

{
<failure-reason>
got a segfault 					
had a bus error 				
had an alignment error 				
just hung 					
went off in the weeds somewhere 		
went out to lunch 				
crashed in a spectacular ball of fire 		
ate the big one and died 			
went into a death spiral 			
collapsed in a pile of smoldering wreckage 	
asserted again 					
spewed these really bizarre messages 		
}

{
<initial-pointer-problem>
<initial-pointer-action>      <pointer-type>    <pointer-problem>	
}

{
<pointer-problem>
<pointer-action>      <pointer-type>    <pointer-problem>	
<pointer-action>      <pointer-type>    <pointer-problem>	
<pointer-action>      <pointer-type>    <pointer-problem>	
<pointer-action>      <pointer-type>    <pointer-problem>	
<pointer-action>      <pointer-type>    <pointer-problem>	
and finally dereferenced a NULL *.				
and ended up calling a NULL function.				
}

{
<initial-pointer-action>
to a				
through a			
dereferencing a			
}

{
<pointer-action>
<initial-pointer-action>	
<initial-pointer-action>	
which was really a		
which should have been a	
}

{
<pointer-type>
char  **			
HashTable  *			
DArray  *			
void  *				
darray  []			
hasharray  []			
}

{
<gdb-problem>
I can't remember <gdb-action> <gdb-result> and <gdb-problem>	
I wish I knew <gdb-action> <gdb-result> and <gdb-problem>	
why won't it <gdb-result> and <gdb-problem>			
I forget where I put that darn gdb handout.			
I wonder where I put my gdb book.				
}

{
<gdb-action>
the command to		
the syntax to		
how to			
the right way to	
the best way to		
any way to		
}

{
<gdb-result>
clear the breakpoints		
dump the local variables	
dump the parameters		
step out of the function	
show the stack trace		
stop before the crash		
}

{
<purify-problem>
I had <purify-error> and <purify-problem>			
there's <purify-error> and <purify-problem>			
for some reason I got <purify-error> and <purify-problem>	
I have to deal with <purify-error> and <purify-problem>		
I leaked  _all_ my memory.					
I leaked 100 percent of my memory.				
}

{
<purify-error>
a UMR error			
an ABR error			
an ABW error			
an NPR radio error		
an NPW error			
a BSR error			
a BSW error			
a FEE FIE FOE FUM error		
a FMR error			
a FMW error			
a FNH error			
}

{
<general-lament>
add some more comments to <my-files> and <general-lament>		
try and get some sleep, and <general-lament>				
try and use only one late day, and <general-lament>			
walk through the <my-code-name> code and <general-lament>		
use a Scanner for stdin, and <general-lament>				
clean up <my-code-name> a bit and <general-lament>			
put those grotesque casts in a helper function, and <general-lament>	
pull that ugly hack out of <my-code-name> and <general-lament>		
read the header files just one more time.				
}


