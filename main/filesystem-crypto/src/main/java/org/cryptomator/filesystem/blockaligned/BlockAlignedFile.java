package org.cryptomator.filesystem.blockaligned;

import java.io.UncheckedIOException;

import org.cryptomator.filesystem.File;
import org.cryptomator.filesystem.delegating.DelegatingFile;

class BlockAlignedFile extends DelegatingFile<BlockAlignedReadableFile, BlockAlignedWritableFile, BlockAlignedFolder> {

	private final int blockSize;

	public BlockAlignedFile(BlockAlignedFolder parent, File delegate, int blockSize) {
		super(parent, delegate);
		this.blockSize = blockSize;
	}

	@Override
	public BlockAlignedReadableFile openReadable() throws UncheckedIOException {
		return new BlockAlignedReadableFile(delegate.openReadable(), blockSize);
	}

	@Override
	public BlockAlignedWritableFile openWritable() throws UncheckedIOException {
		return new BlockAlignedWritableFile(delegate.openWritable(), blockSize);
	}

}