<template>
  <div class="page-wrapper">
    <b-card header="Список деревень" class="big-card shadow">
      <b-list-group>
        <b-list-group-item
          v-for="village in villages"
          :key="village.id"
          class="d-flex align-items-center"
          button
          @click="onClickVillage(village.id)"
        >
          <b-container fluid>
            <b-row class="align-items-center">
              <b-col cols="8">
                <village-list-item :village="village" />
              </b-col>
              <b-col cols="2" class="d-flex justify-content-center">
                <b-button
                  variant="primary"
                  @click.stop="onClickUpdate(village.id)"
                >
                  <b-icon icon="pencil" />
                </b-button>
              </b-col>
              <b-col cols="2" class="d-flex justify-content-center">
                <b-button variant="danger" @click.stop="onDelete(village.id)">
                  <b-icon icon="trash" />
                </b-button>
              </b-col>
            </b-row>
          </b-container>
        </b-list-group-item>
        <b-list-group-item
          class="d-flex align-items-center"
          button
          @click="onClickCreate()"
        >
          <b-container fluid> Создать новую деревню </b-container>
        </b-list-group-item>
      </b-list-group>
      <template v-if="loading">
        <p>Loading...</p>
      </template>
      <template v-if="error !== null">
        <p>Error! {{ error }}</p>
      </template>
    </b-card>
  </div>
</template>

<script>
import { deleteVillageById, getAllVillages } from "../api/villages";
import VillageListItem from "../components/VillageListItem.vue";

export default {
  data() {
    return {
      villages: [],
      loading: false,
      error: null,
    };
  },
  created() {
    this.loadVillages();
  },
  methods: {
    async loadVillages() {
      this.loading = true;
      this.error = null;

      try {
        const res = await getAllVillages();
        this.villages = res.data;
      } catch (e) {
        this.error = "Failed to load villages";
        console.error(e);
      } finally {
        this.loading = false;
      }
    },
    async onDelete(villageId) {
      await deleteVillageById(villageId);
      this.loadVillages();
    },
    onClickUpdate(villageId) {
      this.$router.push(`/villages/${villageId}/update`);
    },
    onClickCreate() {
      this.$router.push("/villages/create");
    },
    onClickVillage(villageId) {
      this.$router.push(`/villages/${villageId}`);
    },
  },
  components: {
    VillageListItem,
  },
};
</script>
