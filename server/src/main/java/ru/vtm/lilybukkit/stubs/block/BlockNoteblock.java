package ru.vtm.lilybukkit.stubs.block;

import net.minecraft.src.Block;
import net.minecraft.src.Material;
import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.block.NoteBlock;
import org.bukkit.material.MaterialData;

/**
 * A stub class for a non-existent block
 */
public class BlockNoteblock extends Block implements NoteBlock {
    protected BlockNoteblock(int id, Material material) {
        super(id, material);
    }

    protected BlockNoteblock(int id, int blockIndex, Material material) {
        super(id, blockIndex, material);
    }

    /**
     * Gets the note.
     *
     * @return
     */
    @Override
    public Note getNote() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Gets the note.
     *
     * @return
     */
    @Override
    public byte getRawNote() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Set the note.
     *
     * @param note
     */
    @Override
    public void setNote(Note note) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Set the note.
     *
     * @param note
     */
    @Override
    public void setRawNote(byte note) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Attempts to play the note at block<br />
     * <br />
     * If the block is no longer a note block, this will return false
     *
     * @return true if successful, otherwise false
     */
    @Override
    public boolean play() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Plays an arbitrary note with an arbitrary instrument
     *
     * @param instrument
     * @param note
     * @return true if successful, otherwise false
     */
    @Override
    public boolean play(byte instrument, byte note) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Plays an arbitrary note with an arbitrary instrument
     *
     * @param instrument
     * @param note
     * @return true if successful, otherwise false
     */
    @Override
    public boolean play(Instrument instrument, Note note) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Gets the block represented by this BlockState
     *
     * @return Block that this BlockState represents
     */
    @Override
    public org.bukkit.block.Block getBlock() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Sets the metadata for this block
     *
     * @param data New block specific metadata
     */
    @Override
    public void setData(MaterialData data) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Attempts to update the block represented by this state, setting it to the
     * new values as defined by this state. <br />
     * <br />
     * This has the same effect as calling update(false). That is to say,
     * this will not modify the state of a block if it is no longer the same
     * type as it was when this state was taken. It will return false in this
     * eventuality.
     *
     * @return true if the update was successful, otherwise false
     * @see BlockState.update(boolean force)
     */
    @Override
    public boolean update() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Attempts to update the block represented by this state, setting it to the
     * new values as defined by this state. <br />
     * <br />
     * Unless force is true, this will not modify the state of a block if it is
     * no longer the same type as it was when this state was taken. It will return
     * false in this eventuality.<br />
     * <br />
     * If force is true, it will set the type of the block to match the new state,
     * set the state data and then return true.
     *
     * @param force true to forcefully set the state
     * @return true if the update was successful, otherwise false
     */
    @Override
    public boolean update(boolean force) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public byte getRawData() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
