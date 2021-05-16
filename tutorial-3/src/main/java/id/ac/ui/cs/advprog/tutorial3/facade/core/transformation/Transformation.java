package id.ac.ui.cs.advprog.tutorial3.facade.core.transformation;

import id.ac.ui.cs.advprog.tutorial3.facade.core.misc.Spell;

public interface Transformation {
    Spell encode(Spell spell);
    Spell decode(Spell spell);
}
