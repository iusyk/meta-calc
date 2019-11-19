DESCRIPTION = "Recipe for calc"
PR = "r0"

SRC_URI = "file://home/ihorusyk/myproject/meta-calc/calc/calc.c \
           file://home/ihorusyk/myproject/meta-calc/calc/helpers.c \
           file://home/ihorusyk/myproject/meta-calc/calc/README.txt"

do_compile(){
 ${CC} ${CFLAGS} ${LDFLAGS} ${WORKDIR}/helpers.c -o helpers
 ${CC} ${CFLAGS} ${LDFLAGS} ${WORKDIR}/calc.c -o calc
}

do_install(){
   install -m 0755 -d ${D}${bindir} ${D}${docdir}/calc
   install -m 0644 ${S}/calc ${D}${bindir}
   install -m 0644 ${WORKDIR}/README.txt ${D}${docdir}/calc
}

