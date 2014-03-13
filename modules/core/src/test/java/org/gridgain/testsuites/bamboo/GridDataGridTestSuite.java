/* @java.file.header */

/*  _________        _____ __________________        _____
 *  __  ____/___________(_)______  /__  ____/______ ____(_)_______
 *  _  / __  __  ___/__  / _  __  / _  / __  _  __ `/__  / __  __ \
 *  / /_/ /  _  /    _  /  / /_/ /  / /_/ /  / /_/ / _  /  _  / / /
 *  \____/   /_/     /_/   \_,__/   \____/   \__,_/  /_/   /_/ /_/
 */

package org.gridgain.testsuites.bamboo;

import junit.framework.*;
import org.gridgain.grid.cache.hibernate.*;
import org.gridgain.grid.cache.store.*;
import org.gridgain.grid.cache.store.hibernate.*;
import org.gridgain.grid.cache.store.jdbc.*;
import org.gridgain.grid.kernal.processors.cache.*;
import org.gridgain.grid.kernal.processors.cache.distributed.*;
import org.gridgain.grid.kernal.processors.cache.distributed.dht.*;
import org.gridgain.grid.kernal.processors.cache.distributed.dht.atomic.*;
import org.gridgain.grid.kernal.processors.cache.distributed.near.*;
import org.gridgain.grid.kernal.processors.cache.distributed.replicated.*;
import org.gridgain.grid.kernal.processors.cache.distributed.replicated.preloader.*;
import org.gridgain.grid.kernal.processors.cache.local.*;
import org.gridgain.grid.kernal.processors.dataload.*;
import org.gridgain.grid.kernal.websession.*;
import org.gridgain.grid.p2p.*;
import org.gridgain.testframework.*;
import org.gridgain.testsuites.*;

/**
 * Test suite.
 */
public class GridDataGridTestSuite extends TestSuite {
    /**
     * @return GridGain TeamCity in-memory data grid test suite.
     * @throws Exception Thrown in case of the failure.
     */
    public static TestSuite suite() throws Exception {
        TestSuite suite = GridTestUtils.createLocalTestSuite("Gridgain In-Memory Data Grid Test Suite");

        // Swap tests.
        suite.addTestSuite(GridCacheSwapPreloadSelfTest.class);
        suite.addTestSuite(GridCacheOffHeapSelfTest.class);
        suite.addTestSuite(GridCacheOffHeapAndSwapSelfTest.class);
        suite.addTestSuite(GridCacheSwapSelfTest.class);
        suite.addTestSuite(GridCacheSwapReloadSelfTest.class);

        // Common tests.
        suite.addTestSuite(GridCacheAffinityMapperSelfTest.class);
        suite.addTestSuite(GridCacheAffinityRoutingSelfTest.class);
        suite.addTestSuite(GridCacheJtaSelfTest.class);
        suite.addTestSuite(GridCacheReplicatedJtaSelfTest.class);
        suite.addTestSuite(GridCacheMvccSelfTest.class);
        suite.addTestSuite(GridCacheMvccPartitionedSelfTest.class);
        suite.addTestSuite(GridCacheMvccManagerSelfTest.class);
//        suite.addTestSuite(GridCacheP2PUndeploySelfTest.class); TODO uncomment in DR branch.
        suite.addTestSuite(GridCacheConfigurationValidationSelfTest.class);
        suite.addTestSuite(GridCacheConfigurationConsistencySelfTest.class);
        suite.addTestSuite(GridCacheHibernateBlobStoreSelfTest.class);
        suite.addTestSuite(GridCacheJdbcBlobStoreSelfTest.class);
        suite.addTestSuite(GridCacheJdbcBlobStoreMultithreadedSelfTest.class);
        suite.addTestSuite(GridCacheAffinityApiSelfTest.class);
        suite.addTestSuite(GridCacheStoreValueBytesSelfTest.class);
        suite.addTestSuite(GridDataLoaderProcessorSelfTest.class);
        suite.addTestSuite(GridDataLoaderImplSelfTest.class);
        suite.addTestSuite(GridCacheEntryMemorySizeSelfTest.class);
        suite.addTestSuite(GridCacheClearAllSelfTest.class);
        suite.addTestSuite(GridCacheGlobalClearAllSelfTest.class);
        suite.addTestSuite(GridCacheObjectToStringSelfTest.class);
        suite.addTestSuite(GridCacheLoadOnlyStoreAdapterSelfTest.class);
        suite.addTestSuite(GridCacheGetStoreErrorSelfTest.class);
        suite.addTestSuite(GridCacheAsyncOperationsLimitSelfTest.class);
        suite.addTestSuite(GridCacheTtlManagerSelfTest.class);
        suite.addTestSuite(GridCacheLifecycleAwareSelfTest.class);

        // Local cache.
        suite.addTestSuite(GridCacheLocalProjectionSelfTest.class);
        suite.addTestSuite(GridCacheLocalBasicApiSelfTest.class);
        suite.addTestSuite(GridCacheLocalBasicStoreNoBatchSelfTest.class);
        suite.addTestSuite(GridCacheLocalBasicStoreSelfTest.class);
        suite.addTestSuite(GridCacheLocalLoadAllSelfTest.class);
        suite.addTestSuite(GridCacheLocalLockSelfTest.class);
        suite.addTestSuite(GridCacheLocalMultithreadedSelfTest.class);
        suite.addTestSuite(GridCacheLocalRefreshAheadSelfTest.class);
        suite.addTestSuite(GridCacheLocalTxSingleThreadedSelfTest.class);
        suite.addTestSuite(GridCacheLocalTxTimeoutSelfTest.class);
        suite.addTestSuite(GridCacheLocalEventSelfTest.class);
        suite.addTestSuite(GridCacheLocalEvictionEventSelfTest.class);
        suite.addTestSuite(GridCacheVariableTopologySelfTest.class);
        suite.addTestSuite(GridCachePartitionedGetSelfTest.class);
        suite.addTestSuite(GridCacheLocalTxMultiThreadedSelfTest.class);
        suite.addTestSuite(GridCacheLocalTtlSelfTest.class);

        // Partitioned cache.
        suite.addTest(new TestSuite(GridCachePartitionedBasicApiTest.class));
        suite.addTest(new TestSuite(GridCacheNearMultiGetSelfTest.class));
        suite.addTest(new TestSuite(GridCacheNearJobExecutionSelfTest.class));
        suite.addTest(new TestSuite(GridCachePartitionedProjectionSelfTest.class));
        suite.addTest(new TestSuite(GridCacheNearOneNodeSelfTest.class));
        suite.addTest(new TestSuite(GridCacheNearMultiNodeSelfTest.class));
        suite.addTest(new TestSuite(GridCacheNearReadersSelfTest.class));
        suite.addTest(new TestSuite(GridCachePartitionedAffinitySelfTest.class));
        suite.addTest(new TestSuite(GridCacheConsistentHashAffinityFunctionExcludeNeighborsSelfTest.class));
        suite.addTest(new TestSuite(GridCacheRendezvousAffinityFunctionExcludeNeighborsSelfTest.class));
        suite.addTest(new TestSuite(GridCachePartitionedProjectionAffinitySelfTest.class));
        suite.addTest(new TestSuite(GridCachePartitionedBasicOpSelfTest.class));
        suite.addTest(new TestSuite(GridCachePartitionedBasicStoreNoBatchSelfTest.class));
        suite.addTest(new TestSuite(GridCachePartitionedBasicStoreSelfTest.class));
        suite.addTest(new TestSuite(GridCachePartitionedBasicStoreMultiNodeSelfTest.class));
        suite.addTest(new TestSuite(GridCachePartitionedNearDisabledBasicStoreMultiNodeSelfTest.class));
        suite.addTest(new TestSuite(GridCachePartitionedEventSelfTest.class));
        suite.addTest(new TestSuite(GridCachePartitionedLockSelfTest.class));
        suite.addTest(new TestSuite(GridCachePartitionedMultiNodeLockSelfTest.class));
        suite.addTest(new TestSuite(GridCachePartitionedMultiNodeSelfTest.class));
        suite.addTest(new TestSuite(GridCachePartitionedMultiThreadedPutGetSelfTest.class));
        suite.addTest(new TestSuite(GridCachePartitionedNodeFailureSelfTest.class));
        suite.addTest(new TestSuite(GridCachePartitionedExplicitLockNodeFailureSelfTest.class));
        suite.addTest(new TestSuite(GridCachePartitionedRefreshAheadSelfTest.class));
        suite.addTest(new TestSuite(GridCachePartitionedTxSingleThreadedSelfTest.class));
        suite.addTest(new TestSuite(GridCacheColocatedTxSingleThreadedSelfTest.class));
        suite.addTest(new TestSuite(GridCachePartitionedTxTimeoutSelfTest.class));
        suite.addTest(new TestSuite(GridCachePartitionedTtlSelfTest.class));
        suite.addTest(new TestSuite(GridCacheFinishPartitionsSelfTest.class));
        suite.addTest(new TestSuite(GridCacheDhtEntrySelfTest.class));
        suite.addTest(new TestSuite(GridCacheDhtInternalEntrySelfTest.class));
        suite.addTest(new TestSuite(GridCacheDhtMappingSelfTest.class));
//        suite.addTest(new TestSuite(GridCachePartitionedTxMultiThreadedSelfTest.class)); TODO-gg-4066
        suite.addTest(new TestSuite(GridCacheDhtPreloadSelfTest.class));
        suite.addTest(new TestSuite(GridCacheDhtPreloadOffHeapSelfTest.class));
        suite.addTest(new TestSuite(GridCacheDhtPreloadBigDataSelfTest.class));
        suite.addTest(new TestSuite(GridCacheDhtPreloadPutGetSelfTest.class));
        suite.addTest(new TestSuite(GridCacheDhtPreloadDisabledSelfTest.class));
        suite.addTest(new TestSuite(GridCacheDhtPreloadMultiThreadedSelfTest.class));
        suite.addTest(new TestSuite(GridCacheColocatedPreloadRestartSelfTest.class));
        suite.addTest(new TestSuite(GridCacheNearPreloadRestartSelfTest.class));
        suite.addTest(new TestSuite(GridCacheDhtPreloadStartStopSelfTest.class));
        suite.addTest(new TestSuite(GridCacheDhtPreloadUnloadSelfTest.class));
        suite.addTest(new TestSuite(GridCachePartitionedAffinityFilterSelfTest.class));
        suite.addTest(new TestSuite(GridCachePartitionedPreloadLifecycleSelfTest.class));
        suite.addTest(new TestSuite(GridCacheDhtPreloadDelayedSelfTest.class));
        //suite.addTest(new TestSuite(GridCachePartitionedFailoverSelfTest.class));  TODO-gg-4813
        //suite.addTest(new TestSuite(GridCacheColocatedFailoverSelfTest.class)); TODO-gg-4813
        suite.addTest(new TestSuite(GridPartitionedBackupLoadSelfTest.class));
        suite.addTest(new TestSuite(GridCachePartitionedLoadCacheSelfTest.class));
        suite.addTest(new TestSuite(GridCacheDhtEvictionsDisabledSelfTest.class));
        suite.addTest(new TestSuite(GridCacheNearEvictionEventSelfTest.class));
        suite.addTest(new TestSuite(GridCacheDhtEvictionSelfTest.class));
        suite.addTest(new TestSuite(GridCacheDhtEvictionNearReadersSelfTest.class));
        suite.addTest(new TestSuite(GridCacheColocatedRefreshAheadSelfTest.class));
//        suite.addTest(new TestSuite(GridCachePartitionedTopologyChangeSelfTest.class)); TODO-gg-5489
        suite.addTest(new TestSuite(GridCachePartitionedPreloadEventsSelfTest.class));
        suite.addTest(new TestSuite(GridCachePartitionedUnloadEventsSelfTest.class));
        suite.addTest(new TestSuite(GridCachePartitionedAffinityHashIdResolverSelfTest.class));
        suite.addTest(new TestSuite(GridCacheColocatedOptimisticTransactionSelfTest.class));
        suite.addTestSuite(GridCacheAtomicMessageCountSelfTest.class);

        suite.addTest(new TestSuite(GridCacheDhtExpiredEntriesPreloadSelfTest.class));
        suite.addTest(new TestSuite(GridCacheNearExpiredEntriesPreloadSelfTest.class));
        suite.addTest(new TestSuite(GridCacheAtomicExpiredEntriesPreloadSelfTest.class));

        // TODO: GG-7242, GG-7243: Enabled when fixed.
//        suite.addTest(new TestSuite(GridCacheDhtRemoveFailureTest.class));
//        suite.addTest(new TestSuite(GridCacheNearRemoveFailureTest.class));
        // TODO: GG-7201: Enable when fixed.
        //suite.addTest(new TestSuite(GridCacheDhtAtomicRemoveFailureTest.class));

        suite.addTest(new TestSuite(GridCacheNearPrimarySyncSelfTest.class));
        suite.addTest(new TestSuite(GridCacheColocatedPrimarySyncSelfTest.class));

        // Value consistency tests.
        suite.addTestSuite(GridCacheValueConsistencyAtomicSelfTest.class);
        suite.addTestSuite(GridCacheValueConsistencyTransactionalSelfTest.class);

        // Replicated cache.
        suite.addTestSuite(GridCacheReplicatedBasicApiTest.class);
        suite.addTestSuite(GridCacheReplicatedBasicOpSelfTest.class);
        suite.addTestSuite(GridCacheReplicatedBasicStoreNoBatchSelfTest.class);
        suite.addTestSuite(GridCacheReplicatedBasicStoreSelfTest.class);
        suite.addTestSuite(GridCacheReplicatedEventSelfTest.class);
        suite.addTestSuite(GridCacheReplicatedSynchronousCommitTest.class);

        // TODO: GG-7437.
        // suite.addTestSuite(GridCacheReplicatedInvalidateSelfTest.class);
        suite.addTestSuite(GridCacheReplicatedLockSelfTest.class);
        // TODO: enable when GG-7437 is fixed.
        //suite.addTestSuite(GridCacheReplicatedMultiNodeLockSelfTest.class);
        //suite.addTestSuite(GridCacheReplicatedMultiNodeSelfTest.class);
        suite.addTestSuite(GridCacheReplicatedNodeFailureSelfTest.class);
        suite.addTestSuite(GridCacheReplicatedProjectionSelfTest.class);
        suite.addTestSuite(GridCacheReplicatedRefreshAheadSelfTest.class);
        suite.addTestSuite(GridCacheReplicatedTxSingleThreadedSelfTest.class);
        suite.addTestSuite(GridCacheReplicatedTxTimeoutSelfTest.class);
        suite.addTestSuite(GridCacheReplicatedPreloadSelfTest.class);
        suite.addTestSuite(GridCacheReplicatedPreloadOffHeapSelfTest.class);
        suite.addTestSuite(GridCacheReplicatedPreloadLifecycleSelfTest.class);
        suite.addTestSuite(GridCacheSyncReplicatedPreloadSelfTest.class);
        // suite.addTestSuite(GridCacheReplicatedFailoverSelfTest.class); TODO: uncomment when fix GG-2239
        suite.addTestSuite(GridCacheDeploymentSelfTest.class);
        suite.addTestSuite(GridCacheDeploymentOffHeapSelfTest.class);
        suite.addTestSuite(GridCachePutArrayValueSelfTest.class);
        suite.addTestSuite(GridMultinodeRedeployContinuousModeSelfTest.class);
        suite.addTestSuite(GridMultinodeRedeploySharedModeSelfTest.class);
        suite.addTestSuite(GridMultinodeRedeployPrivateModeSelfTest.class);
        suite.addTestSuite(GridMultinodeRedeployIsolatedModeSelfTest.class);
        suite.addTestSuite(GridCacheReplicatedUnswapAdvancedSelfTest.class);
        suite.addTestSuite(GridCacheReplicatedEvictionEventSelfTest.class);
        // TODO: GG-7569.
        // suite.addTestSuite(GridCacheReplicatedTxMultiThreadedSelfTest.class);
        suite.addTestSuite(GridCacheReplicatedTtlSelfTest.class);
        suite.addTestSuite(GridCacheReplicatedPreloadEventsSelfTest.class);
        // TODO: GG-7434
        // suite.addTestSuite(GridReplicatedTxPreloadTest.class);

        suite.addTestSuite(GridCacheTxReentryNearSelfTest.class);
        suite.addTestSuite(GridCacheTxReentryColocatedSelfTest.class);

        suite.addTestSuite(GridCacheOrderedPreloadingSelfTest.class);

        // Test for byte array value special case.
        suite.addTestSuite(GridCacheLocalByteArrayValuesSelfTest.class);
        suite.addTestSuite(GridCacheNearPartitionedP2PEnabledByteArrayValuesSelfTest.class);
        suite.addTestSuite(GridCacheNearPartitionedP2PDisabledByteArrayValuesSelfTest.class);
        suite.addTestSuite(GridCachePartitionedOnlyP2PEnabledByteArrayValuesSelfTest.class);
        suite.addTestSuite(GridCachePartitionedOnlyP2PDisabledByteArrayValuesSelfTest.class);
        suite.addTestSuite(GridCacheReplicatedP2PEnabledByteArrayValuesSelfTest.class);
        suite.addTestSuite(GridCacheReplicatedP2PDisabledByteArrayValuesSelfTest.class);

        // TODO uncomment tests when GG-4154 fixed.
//        suite.addTestSuite(GridCacheLocalTxExceptionSelfTest.class);
//        suite.addTestSuite(GridCacheReplicatedTxExceptionSelfTest.class);
//        suite.addTestSuite(GridCacheNearTxExceptionSelfTest.class);
//        suite.addTestSuite(GridCacheColocatedTxExceptionSelfTest.class);

        // Near-only cache.
        suite.addTest(GridCacheNearOnlySelfTestSuite.suite());

        // Test cache with daemon nodes.
        suite.addTestSuite(GridCacheDaemonNodeLocalSelfTest.class);
        suite.addTestSuite(GridCacheDaemonNodePartitionedSelfTest.class);
        suite.addTestSuite(GridCacheDaemonNodeReplicatedSelfTest.class);

        // Write-behind.
        suite.addTest(GridCacheWriteBehindTestSuite.suite());

        // Before-after lock-unlock.
        suite.addTestSuite(GridCacheColocatedBeforeAfterLockSelfTest.class);
        // suite.addTestSuite(GridCacheNearBeforeAfterLockSelfTest.class); TODO gg-6221

        // Transform.
        suite.addTestSuite(GridCachePartitionedTransformWriteThroughBatchUpdateSelfTest.class);
        suite.addTestSuite(GridCachePartitionedTransformWriteThroughSingleUpdateSelfTest.class);
        suite.addTestSuite(GridCacheIncrementTransformTest.class);

        suite.addTestSuite(GridCacheEntryVersionSelfTest.class);
        suite.addTestSuite(GridCacheVersionSelfTest.class);

        // Memory leak tests.
        suite.addTestSuite(GridCacheReferenceCleanupSelfTest.class);
        suite.addTestSuite(GridCacheReloadSelfTest.class);

        // Group locking.
        suite.addTest(GridCacheGroupLockSelfTestSuite.suite());

        // Full API.
        suite.addTest(GridCacheFullApiSelfTestSuite.suite());

        // Cache metrics.
        suite.addTest(GridCacheMetricsSelfTestSuite.suite());

        // DGC.
        suite.addTest(GridCacheDgcSelfTestSuite.suite());

        // Eviction.
        suite.addTest(GridCacheEvictionSelfTestSuite.suite());

        // Iterators.
        suite.addTest(GridCacheIteratorsSelfTestSuite.suite());

        // Web sessions.
        suite.addTest(GridWebSessionSelfTestSuite.suite());

        // Hibernate L2 cache.
        suite.addTestSuite(GridHibernateL2CacheSelfTest.class);
        suite.addTestSuite(GridHibernateL2CacheTransactionalSelfTest.class);
        suite.addTestSuite(GridHibernateL2CacheConfigurationSelfTest.class);

        // Add tx recovery test suite.
        suite.addTest(GridCacheTxRecoverySelfTestSuite.suite());

        return suite;
    }
}
