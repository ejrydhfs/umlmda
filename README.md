# UMLMDA — a UML/MDA Generator Framework

Java tools to read UML models (ArgoUML, Rational Rose, RSM, XMI) and to run generators with
JSP-based templates that generate code from the models. On top of these tools an MDA framework
for business applications is provided.

* Original project: <https://sourceforge.net/projects/umlmda/> (SourceForge, created
  2003-07-08, last commit 2010-07-23).
* Import: the original Subversion repository
  (`https://svn.code.sf.net/p/umlmda/code/`, read-only anonymous access) was converted to Git
  with `git svn clone`. All 1645 revisions, the original author names and the complete
  directory layout are preserved. The repository is flat (every component carries its own
  `trunk`/`branches`/`tags`/`releases` directories), so the SVN tags and branches are kept as
  directories inside the history rather than as Git tags or branches.

## License

GNU Library General Public License, version 2 or later (`LGPL-2.0-or-later`) — see
[`COPYING`](COPYING). The SourceForge project lists the license as "LGPLv2". Most source files
carry the matching header ("This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Library General Public License as published by the Free
Software Foundation; either version 2 of the License, or (at your option) any later version");
a subset of files instead carries the otherwise equivalent LGPL 2.1 wording ("GNU Lesser
General Public License ... version 2.1 ... or later").

Copyright remains with the original authors (see the commit history). Third-party components
under `3rd-party/` and libraries bundled inside the per-component `lib/` directories remain
under their own licenses (e.g. Apache License 2.0 for Velocity, FreeMarker and
commons-collections).
