/**
 * The MIT License (MIT)
 *
 * Copyright (C) 2014 Agile Knowledge Engineering and Semantic Web (AKSW) (usbeck@informatik.uni-leipzig.de)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.aksw.gerbil.datatypes;

/**
 * The type of an experiment.
 * 
 * Hierarchy of experiment types:<br>
 * {@link #Sa2KB} ≻ {@link #Sc2KB}<br>
 * {@link #Sc2KB} ≻ {@link #Rc2KB}<br>
 * {@link #Rc2KB} ≻ {@link #C2KB}<br>
 * {@link #Sa2KB} ≻ {@link #A2KB}<br>
 * {@link #A2KB} ≻ {@link #C2KB}<br>
 * {@link #A2KB} ≻ {@link #D2KB}<br>
 * 
 * <p>
 * {@link #Sa2KB} is the hardest problem containing all others while {@link #C2KB} and {@link #D2KB} are the leaves of the
 * hierarchy.
 * </p>
 * 
 * @author m.roeder
 * 
 */

// TODO add to String with better naming and info method
public enum ExperimentType {
    /**
     * Disambiguate to Wikipedia
     * <p>
     * Assign to each input mention its pertinent entity (possibly null).
     * </p>
     * Input: text with marked entities <br>
     * Output: mentions for every entity
     */
    D2KB,
    /**
     * Annotate to Wikipedia
     * <p>
     * Identify the relevant mentions in the input text and assign to each of them the pertinent entities.
     * </p>
     * Input: text<br>
     * Output: marked entities and mentions for their meaning
     */
    A2KB,
    /**
     * Scored-annotate to Wikipedia
     * <p>
     * Identify the relevant mentions in the input text and assign to each of them the pertinent entities. Additionally,
     * each annotation is assigned a score representing the likelihood that the annotation is correct.
     * </p>
     * Input: text<br>
     * Output: marked entities and scored mentions for their meaning
     */
    Sa2KB,
    /**
     * Concepts to Wikipedia
     * <p>
     * Tags are taken as the set of relevant entities that are mentioned in the input text.
     * </p>
     * Input: text<br>
     * Output: marked entities
     */
    C2KB,
    /**
     * Scored concepts to Wikipedia
     * <p>
     * Tags are taken as the set of relevant entities that are mentioned in the input text. Additionally, each tag is
     * assigned a score representing the likelihood that the annotation is correct.
     * </p>
     * Input: text<br>
     * Output: scored markings of entities
     */
    Sc2KB,
    /**
     * Ranked-concepts to Wikipedia
     * <p>
     * Identify the entities mentioned in a text and rank them in terms of their relevance for the topics dealt with in
     * the input text.
     * </p>
     * Input: text<br>
     * Output: ranked markings of entities
     */
    Rc2KB;

    public boolean equalsOrContainsType(ExperimentType type) {
        switch (this) {
        case Sa2KB: {
            return true;
        }
        case Sc2KB: {
            switch (type) {
            case Sa2KB: // falls through
            case A2KB:
            case D2KB: {
                return false;
            }
            case Sc2KB: // falls through
            case Rc2KB:
            case C2KB: {
                return true;
            }
            }
        }
        case Rc2KB: {
            switch (type) {
            case Sa2KB: // falls through
            case Sc2KB:
            case A2KB:
            case D2KB: {
                return false;
            }
            case Rc2KB: // falls through
            case C2KB: {
                return true;
            }
            }
        }
        case A2KB: {
            switch (type) {
            case Sa2KB: // falls through
            case Sc2KB:
            case Rc2KB:
            case C2KB: {
                return false;
            }
            case A2KB: // falls through
            case D2KB: {
                return true;
            }
            }
        }
        case C2KB: {
            switch (type) {
            case Sa2KB: // falls through
            case Sc2KB:
            case Rc2KB:
            case A2KB:
            case D2KB: {
                return false;
            }
            case C2KB: {
                return true;
            }
            }
        }
        case D2KB: {
            switch (type) {
            case Sa2KB: // falls through
            case Sc2KB:
            case Rc2KB:
            case A2KB:
            case C2KB: {
                return false;
            }
            case D2KB: {
                return true;
            }
            }
        }
        }
        return false;
    }
}
