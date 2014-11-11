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
package org.aksw.gerbil.annotators;

import it.acubelab.batframework.problems.TopicSystem;
import it.acubelab.batframework.systemPlugins.DBPediaApi;
import it.acubelab.batframework.utils.WikipediaApiInterface;

import org.aksw.gerbil.bat.annotator.nif.NIFBasedAnnotatorWebservice;
import org.aksw.gerbil.datatypes.ExperimentType;

public class NIFWebserviceAnnotatorConfiguration extends AbstractAnnotatorConfiguration {

    public static final String ANNOTATOR_NAME = "NIF-based Web Service";

    private String annotaturURL;
    private WikipediaApiInterface wikiApi;
    private DBPediaApi dbpediaApi;

    public NIFWebserviceAnnotatorConfiguration(String annotaturURL, String annotatorName, boolean couldBeCached,
            WikipediaApiInterface wikiApi, DBPediaApi dbpediaApi, ExperimentType... applicableForExperiment) {
        super(annotatorName, couldBeCached, applicableForExperiment);
        this.annotaturURL = annotaturURL;
        this.wikiApi = wikiApi;
        this.dbpediaApi = dbpediaApi;
    }

    @Override
    protected TopicSystem loadAnnotator(ExperimentType type) throws Exception {
        return new NIFBasedAnnotatorWebservice(annotaturURL, this.getName(), wikiApi, dbpediaApi);
    }

}
