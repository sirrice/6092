# Converts .txt into .html using asciidoc

ASCIIDOC=tools/asciidoc/asciidoc.py

OUTPUTS=runbook.html installjava.html syllabus.html todo.html

all: $(OUTPUTS)

%.html : %.txt plain.css
	$(ASCIIDOC) --unsafe -a stylesdir=`pwd` -a theme=plain -o $@ $<

runbook.html : runbook.txt plain.css
	$(ASCIIDOC) --unsafe -a stylesdir=`pwd` -a theme=plain -a toc -o $@ $<

clean:
	$(RM) $(OUTPUTS)
