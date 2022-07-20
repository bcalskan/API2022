package z_deneme.z_deneme_pojos;

public class DenemeGoRestOuterDataPojo {
    //         {
    //    "meta": null,
    //    "data": {
    //        "id": 255,
    //        "name": "Dhanapati Menon DVM",
    //        "email": "dvm_dhanapati_menon@abernathy.co",
    //        "gender": "male",
    //        "status": "active"
    //    }
    //}

    private Object meta;
    private DenemeGoRestInnerDataPojo data;

    public DenemeGoRestOuterDataPojo(Object meta, DenemeGoRestInnerDataPojo data) {
        this.meta = meta;
        this.data = data;
    }

    public DenemeGoRestOuterDataPojo() {
    }

    public Object getMeta() {
        return meta;
    }

    public void setMeta(Boolean meta) {
        this.meta = meta;
    }

    public DenemeGoRestInnerDataPojo getData() {
        return data;
    }

    public void setData(DenemeGoRestInnerDataPojo data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DenemeGoRestOuterDataPojo{" +
                "meta=" + meta +
                ", data=" + data +
                '}';
    }
}
