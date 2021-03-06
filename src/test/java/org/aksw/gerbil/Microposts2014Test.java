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
package org.aksw.gerbil;

import it.acubelab.batframework.utils.WikipediaApiInterface;

import org.aksw.gerbil.annotators.NERDAnnotatorConfig;
import org.aksw.gerbil.database.SimpleLoggingDAO4Debugging;
import org.aksw.gerbil.datasets.Microposts2014Config;
import org.aksw.gerbil.datasets.Microposts2014Config.Microposts2014Chunk;
import org.aksw.gerbil.datatypes.ExperimentTaskConfiguration;
import org.aksw.gerbil.datatypes.ExperimentType;
import org.aksw.gerbil.matching.Matching;
import org.aksw.gerbil.utils.SingletonWikipediaApi;
import org.aksw.simba.topicmodeling.concurrent.overseers.simple.SimpleOverseer;
import org.junit.Ignore;

/**
 * Class for testing the microposts dataset.
 * 
 * @author Giuseppe Rizzo <giuse.rizzo@gmail.com>
 */
@Ignore
public class Microposts2014Test {

    public static void main(String[] args) {

        WikipediaApiInterface wikiAPI = SingletonWikipediaApi.getInstance();
        ExperimentTaskConfiguration taskConfigs[] =
                new ExperimentTaskConfiguration[]
                {
                        new ExperimentTaskConfiguration(
                                new NERDAnnotatorConfig(wikiAPI),
                                new Microposts2014Config(Microposts2014Chunk.TRAIN, SingletonWikipediaApi.getInstance()),
                                ExperimentType.D2KB,
                                Matching.STRONG_ANNOTATION_MATCH) };
        Experimenter experimenter = new Experimenter(wikiAPI, new SimpleOverseer(),
                new SimpleLoggingDAO4Debugging(),
                taskConfigs,
                "MICROPOSTS_TEST");
        experimenter.run();

    }

}
