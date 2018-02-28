/*
 *
 * Copyright 2018 EMBL - European Bioinformatics Institute
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package uk.ac.ebi.ampt2d.accession.file.persistence;

import uk.ac.ebi.ampt2d.accession.file.FileModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class FileEntity implements FileModel {

    @Column(nullable = false, unique = true)
    private String hashedMessage;

    @Id
    @Column(nullable = false, unique = true, length = 230)
    @Size(max = 230, min = 0)
    private String accession;

    FileEntity() {
    }

    public FileEntity(String hashedMessage, String accession) {
        this.hashedMessage = hashedMessage;
        this.accession = accession;
    }

    public String getHashedMessage() {
        return hashedMessage;
    }

    public String getAccession() {
        return accession;
    }

    @Override
    public String getHash() {
        return hashedMessage;
    }
}
