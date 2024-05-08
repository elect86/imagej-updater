/*
 * #%L
 * ImageJ software for multidimensional image processing and analysis.
 * %%
 * Copyright (C) 2009 - 2024 Board of Regents of the University of
 * Wisconsin-Madison, Broad Institute of MIT and Harvard, and Max Planck
 * Institute of Molecular Cell Biology and Genetics.
 * %%
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */
package net.imagej.updater;

import static net.imagej.updater.UpdaterTestUtils.addUpdateSite;
import static net.imagej.updater.UpdaterTestUtils.assertStatus;
import static net.imagej.updater.UpdaterTestUtils.initialize;
import static net.imagej.updater.UpdaterTestUtils.writeFile;
import static org.junit.Assert.assertTrue;

import java.io.File;

import net.imagej.updater.FileObject.Status;

/**
 * A simple starting point for interactive testing of the updater (GUI).
 * 
 * @author Johannes Schindelin
 */
public class InteractiveTestDrive {
	public static void main(String[] args) throws Exception {
		final String path = "macros/test.ijm";
		final String obsolete = "macros/obsolete.ijm";
		FilesCollection files = initialize(path, obsolete);

		assertTrue(files.prefix(obsolete).delete());
		files = UpdaterTestUtils.main(files, "upload", obsolete);

		final File tmp = addUpdateSite(files, "second");
		writeFile(files.prefix(path), "// shadowing");
		writeFile(files.prefix(obsolete), obsolete);
		files = UpdaterTestUtils.main(files, "upload-complete-site", "--force-shadow", "second");

		assertStatus(Status.INSTALLED, files, path);
		assertStatus(Status.INSTALLED, files, obsolete);
		files = UpdaterTestUtils.main(files, "remove-update-site", "second");

		assertStatus(Status.MODIFIED, files, path);
		assertStatus(Status.OBSOLETE, files, obsolete);

		UpdaterTestUtils.show(files);
		UpdaterTestUtils.deleteRecursivelyAtLeastOnExit(tmp);
	}
}
