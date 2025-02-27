package eu.europa.esig.dss.cades.extension;

import eu.europa.esig.dss.cades.CAdESSignatureParameters;
import eu.europa.esig.dss.enumerations.SignatureLevel;
import eu.europa.esig.dss.enumerations.SignaturePackaging;
import eu.europa.esig.dss.model.DSSDocument;

import java.util.Arrays;
import java.util.List;

public class CAdESExtensionTToLTDetachedTest extends AbstractCAdESTestExtension {

    @Override
    protected SignatureLevel getOriginalSignatureLevel() {
        return SignatureLevel.CAdES_BASELINE_T;
    }

    @Override
    protected SignatureLevel getFinalSignatureLevel() {
        return SignatureLevel.CAdES_BASELINE_LT;
    }

    @Override
    protected CAdESSignatureParameters getSignatureParameters() {
        CAdESSignatureParameters signatureParameters = super.getSignatureParameters();
        signatureParameters.setSignaturePackaging(SignaturePackaging.DETACHED);
        return signatureParameters;
    }

    @Override
    protected CAdESSignatureParameters getExtensionParameters() {
        CAdESSignatureParameters extensionParameters = super.getExtensionParameters();
        extensionParameters.setDetachedContents(getDetachedContents());
        return extensionParameters;
    }

    @Override
    protected List<DSSDocument> getDetachedContents() {
        return Arrays.asList(getOriginalDocument());
    }

}
