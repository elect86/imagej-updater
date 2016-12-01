/*
 * #%L
 * ImageJ software for multidimensional image processing and analysis.
 * %%
 * Copyright (C) 2009 - 2016 Board of Regents of the University of
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

package net.imagej.updater.action;

import net.imagej.updater.FileObject;
import net.imagej.updater.FilesCollection;
import net.imagej.updater.GroupAction;
import net.imagej.updater.FileObject.Action;

/**
 * The <i>uninstall</i> action.
 * 
 * <p>
 * This class determines whether a bunch of files can be uninstalled, how to
 * mark them to be uninstalled, and what to call this action in the GUI.
 * </p>
 * 
 * @author Johannes Schindelin
 */
public class Uninstall implements GroupAction {

	@Override
	public boolean isValid(FilesCollection files, FileObject file) {
		return file.getStatus().isValid(Action.UNINSTALL);
	}

	@Override
	public void setAction(FilesCollection files, FileObject file) {
		file.setAction(files, Action.UNINSTALL);
	}

	@Override
	public String getLabel(FilesCollection files, Iterable<FileObject> selected) {
		return "Uninstall";
	}

	@Override
	public String toString() {
		return "Uninstall";
	}

}
