package co.arichardson.gradle.make.tasks

class GnuMake extends OutputRedirectingExec {
    Object makefile

    public GnuMake() {
        executable 'make'
        args '-j', project.gradle.startParameter.maxWorkerCount
    }

    @Override
    protected void exec() {
        if (makefile) {
            args = ['-f', project.file(makefile).path] + args
        }

        super.exec()
    }

    @Override
    boolean equals(Object other) {
        other in GnuMake &&
            makefile == other.makefile &&
            super.equals(other)
    }

    void makefile(Object makefile) {
        this.makefile = makefile
    }
}
